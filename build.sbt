import sbt._
import scala.sys.process._
import java.io.File
import Dependencies._

ThisBuild / organization := "com.example"
// ThisBuild / scalaVersion := "2.13.12"
// ThisBuild / name := "Scala-Foo"
//ThisBuild / useSuperShell := false


def createModule(moduleName: String): Project = 
  Project(id = s"$moduleName", base = file(moduleName))
  .settings(
    name := s"$moduleName",
    scalaVersion := "2.13.12",
    libraryDependencies ++= Seq(
      Dependencies.catsCore.value,
      Dependencies.catsEffect.value,
      // Dependencies.miniTest.value,
      // Dependencies.miniTestLaws.value,
      Dependencies.munit.value,
      scalaTest % Test
    )
  )

lazy val root = (project in file("."))
  .aggregate(fpinscala, example, state)
  .settings(
    name := "Scala-Foo",
    scalaVersion := "2.13.12"
  )

lazy val httpProject = (project in file("ping"))
  .settings(
    name := "fp-http",
    scalaVersion := "2.13.12",
    libraryDependencies ++= Seq(
      Dependencies.http4sBlazeServer.value,
      Dependencies.http4sBlazeClient.value,
      Dependencies.http4sCirce.value,
      Dependencies.http4sDsl.value,
      Dependencies.logback.value,
      Dependencies.janino.value,
    )
  )

lazy val workProject = (project in file("work"))
  .settings(
    name := "fp-work",
    scalaVersion := "2.13.12",
    libraryDependencies ++= Seq(
      Dependencies.catsCore.value,
      Dependencies.catsEffect.value,
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