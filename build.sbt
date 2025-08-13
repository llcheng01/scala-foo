import sbt._
import scala.sys.process._
import java.io.File
import Dependencies._

ThisBuild / organization := "com.example"
ThisBuild / scalaVersion := "2.13.12"
// ThisBuild / name := "Scala-Foo"
//ThisBuild / useSuperShell := false

lazy val commonSettings = Seq(
  scalacOptions ++= Seq(
    "-deprecation",
    "-feature",
    "-unchecked",
    "-language:higherKinds"
  ),
  scalacOptions --= Seq(
    "-Xlint:by-name-right-associative",
    "-Xlint:nullary-override",
    "-Xlint:unsound-match",
    "-Yno-adapted-args"
  ),
  libraryDependencies ++= Seq(
    Dependencies.catsCore.value,
    Dependencies.catsEffect.value,
    Dependencies.munit.value,
    Dependencies.scalaTest % Test
  )
)

lazy val root = (project in file("."))
  .aggregate(fpinscala, example, state, ping, work)
  .settings(
    name := "Scala-Foo",
    scalaVersion := "2.12.18",
    publish / skip := true
  )

lazy val fpinscala = (project in file("fpinscala"))
  .settings(commonSettings)
  .settings(
    name := "fpinscala"
  )

lazy val example = (project in file("example"))
  .settings(commonSettings)
  .settings(
    name := "example"
  )

lazy val ping = (project in file("ping"))
  .settings(commonSettings)
  .settings(
    name := "ping",
    libraryDependencies ++= Seq(
      Dependencies.http4sBlazeServer.value,
      Dependencies.http4sBlazeClient.value,
      Dependencies.http4sCirce.value,
      Dependencies.http4sDsl.value,
      Dependencies.logback.value,
      Dependencies.janino.value
    )
  )

lazy val state = (project in file("state"))
  .settings(commonSettings)
  .settings(
    name := "state"
  )

lazy val work = (project in file("work"))
  .settings(commonSettings)
  .settings(
    name := "ping",
    libraryDependencies ++= Seq(
      Dependencies.circeCore.value,
      Dependencies.circeParser.value,
      Dependencies.circeGeneric.value
    )
  )

lazy val fpinscala = createModule("fpinscala")
lazy val example = createModule("example")
lazy val state = createModule("state")

scalacOptions --= Seq(
  "-Xlint:by-name-right-associative",
  "-Xlint:nullary-override",
  "-Xlint:unsound-match",
  "-Yno-adapted-args"
)