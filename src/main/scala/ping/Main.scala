package ping

import cats.implicits._
import cats.effect.{ExitCode, IO, IOApp}

object Main extends IOApp {
  override def run(args: List[String]): IO[ExitCode] =
    PingServer.stream.compile.drain.as(ExitCode.Success)
}
