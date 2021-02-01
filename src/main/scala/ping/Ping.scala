package ping

import cats.effect.IO
import io.circe.{Encoder, Json}
import org.http4s.EntityEncoder
import org.http4s.circe._

object Ping {

  final case class Pong(message: String) extends AnyVal

  def ping(message: String): IO[Pong] =
    IO(Pong(message))

  object Pong {
    implicit val pongEncoder: Encoder[Pong] = new Encoder[Pong] {
      override def apply(a: Pong): Json = Json.obj(
        ("message", Json.fromString(a.message))
      )
    }

    implicit val pongEntityEncoder: EntityEncoder[IO, Pong] =
      jsonEncoderOf[IO, Pong]
  }
}
