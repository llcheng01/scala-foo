import cats.syntax.all._
import cats.effect.kernel.{MonadCancelThrow, Concurrent}
import java.time.temporal.ChronoUnit
import java.time.ZoneId


trait ExternalPayments[F[_]] {
  def hasExternalPaymentToday(institutionId: InstitutionId, number: CreditCardNumber): F[Boolean]

  def addExternalPaymentTo(institutionId: InstitutionId, number: CreditCardNumber): F[Unit]

  def removeExternalPaymentTo(institutionId: InstitutionId, number: CreditCardNumber): F[Unit]

  def removeHistoricalPayments(): F[Unit]
}

object ExternalPayments {
    def postgresImpl[F[_]: MonadCancelThrow: Clock](transactor: Transactor[F]): ExternalPayments[F] = 
        new ExternalPayments {
            def hasExternalPaymentToday(institutionId: InstitutionId, number: CreditCardNumber): F[Boolean] = 
                (hash(institutionId, number), Scheduling.pscu.derviceCuttOff[F]).flatMapN {
                    (hashed, cutoff) => 
                        Queries.postgres
                            .selectExternalPayment(institutionId, hashed, cutoff.toOffsetDateTime)
                            .unique
                            .transact(transactor)
                }
            
            def addExternalPaymentTo(institutionId: InstitutionId, number: CreditCardNumber): F[Unit] = 
                Clock[F].realTimeInstant
                    .map(_.atZone(ZoneId.of("America/Chicago")))
                    .flatMap { createdAt =>
                        hash(institutionId, number).flatMap { hashed =>
                            Queries.postgres
                                .insertExternalPayment(institutionId, hashed, createdAt.toOffsetDateTime)
                                .run
                                .transact(transactor)
                                .void
                        }
                    }
        
            def removeExternalPaymentTo(institutionId: InstitutionId, number: CreditCardNumber): F[Unit] = 
                hash(institutionId, number).flatMap { hashed =>
                    Queries.postgres
                        .deleteExternalPayment(institutionId, hashed)
                        .run
                        .transact(transactor)
                        .void
                }
            
            def removeHistoricalPayments(): F[Unit] = 
                Clock[F].realTimeInstant
                    .map(_.minus(2, ChronoUnit.DAYS))
                    .map(_.atZone(ZoneId.of("America/Chicago")))
                    .flatMap(cutoff =>
                        Queries.postgres
                            .removeHistoricalPayments(cutoff.toOffsetDateTime)
                            .run
                            .transact(transactor)
                            .void    
                    )

            private def hash(institutionId: InstitutionId, number: CreditCardNumber): F[String] = 
                ByteVector.encondeUtf8(s"$institutionId:$number")
                    .liftTo[F]
                    .map(_.digest("SHA-256").toHex)
        }
}


case class InstitutionId(value: String)
case class CreditCardNumber(number: String)