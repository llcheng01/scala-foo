import sbt._

object Dependencies {
  // Library Versions
  val catsVersion = "2.1.0"
  val catsEffectVersion = "2.1.1"
  val circeVersion = "0.12.3"

  val http4sVersion = "0.21.0"

  val logbackVersion = "1.2.3"
  val janinoVersion = "3.1.0"

  val miniTestVersion = "2.7.0"
  val scalaCheckVersion = "1.14.1"
  val munitVersion = "1.0.0"

  // Libraries
  val catsEffect =
    Def.setting("org.typelevel" %% "cats-effect" % catsEffectVersion)
  val catsCore = Def.setting("org.typelevel" %% "cats-core" % catsVersion)

  val miniTest =
    Def.setting("io.monix" %% "minitest" % miniTestVersion % "test")
  val miniTestLaws =
    Def.setting("io.monix" %% "minitest-laws" % miniTestVersion % "test")

  val munit = Def.setting("org.scalameta" %% "munit" % munitVersion % Test)

  val http4sBlazeServer =
    Def.setting("org.http4s" %% "http4s-blaze-server" % http4sVersion)
  val http4sBlazeClient =
    Def.setting("org.http4s" %% "http4s-blaze-client" % http4sVersion)
  val http4sCirce = Def.setting("org.http4s" %% "http4s-circe" % http4sVersion)
  val http4sDsl = Def.setting("org.http4s" %% "http4s-dsl" % http4sVersion)

  val logback =
    Def.setting("ch.qos.logback" % "logback-classic" % logbackVersion)
  val janino = Def.setting("org.codehaus.janino" % "janino" % janinoVersion)

  val circeCore = Def.setting("io.circe" %% "circe-core" % circeVersion)
  val circeParser = Def.setting("io.circe" %% "circe-parser" % circeVersion)
  val circeGeneric = Def.setting("io.circe" %% "circe-generic" % circeVersion)

  val circeCore    = Def.setting("io.circe" %% "circe-core"    % circeVersion)
  val circeParser  = Def.setting("io.circe" %% "circe-parser"  % circeVersion)
  val circeGeneric = Def.setting("io.circe" %% "circe-generic" % circeVersion)
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.8"
}
