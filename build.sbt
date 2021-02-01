import sbt._
import scala.sys.process._
import java.io.File
import Dependencies._

ThisBuild / organization := "com.example"
ThisBuild / scalaVersion := "2.12.4"
ThisBuild / name := "Scala Foo"
//ThisBuild / useSuperShell := false

lazy val root = (project in file(".")).
  settings(
    libraryDependencies ++= Seq(
      Dependencies.catsCore.value,
      Dependencies.catsEffect.value,
      Dependencies.miniTest.value,
      Dependencies.miniTestLaws.value,
      Dependencies.http4sBlazeServer.value,
      Dependencies.http4sBlazeClient.value,
      Dependencies.http4sCirce.value,
      Dependencies.http4sDsl.value,
      Dependencies.logback.value,
      Dependencies.janino.value,
      scalaTest % Test
    )
  )
