error id: file://<WORKSPACE>/build.sbt:`<none>`.
file://<WORKSPACE>/build.sbt
empty definition using pc, found symbol in pc: `<none>`.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -sbt/Dependencies.munit.value.
	 -sbt/Dependencies.munit.value#
	 -sbt/Dependencies.munit.value().
	 -scala/sys/process/Dependencies.munit.value.
	 -scala/sys/process/Dependencies.munit.value#
	 -scala/sys/process/Dependencies.munit.value().
	 -Dependencies.Dependencies.munit.value.
	 -Dependencies.Dependencies.munit.value#
	 -Dependencies.Dependencies.munit.value().
	 -Dependencies.munit.value.
	 -Dependencies.munit.value#
	 -Dependencies.munit.value().
	 -scala/Predef.Dependencies.munit.value.
	 -scala/Predef.Dependencies.munit.value#
	 -scala/Predef.Dependencies.munit.value().
offset: 983
uri: file://<WORKSPACE>/build.sbt
text:
```scala
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
  )
)


def createModule(moduleName: String, mainDeps: Seq[ModuleID] = Seq.empty, testDeps: Seq[ModuleID] = Seq.empty): Project = 
  Project(id = s"$moduleName", base = file(moduleName))
    .settings(commonSettings)
    .settings(
      name := s"$moduleName",
      libraryDependencies ++= Seq(
        Dependencies.catsCore.value,
        Dependencies.catsEffect.value
      ) ++ mainDeps,
      libraryDependencies ++= Seq(
        Dependencies.munit.v@@alue,
        scalaTest % Test
      ) ++ testDeps.map(_ % Test)
    )

lazy val root = (project in file("."))
  .aggregate(fpinscala, example, state, ping, work)
  .settings(
    name := "Scala-Foo",
    scalaVersion := "2.12.18",
    publish / skip := true
  )

lazy val fpinscala = createModule("fpinscala")

lazy val example = createModule("example")

lazy val ping = createModule(
  "ping",
    mainDeps = Seq(
      Dependencies.http4sBlazeServer.value,
      Dependencies.http4sBlazeClient.value,
      Dependencies.http4sCirce.value,
      Dependencies.http4sDsl.value,
      Dependencies.logback.value,
      Dependencies.janino.value,
    )
  )

lazy val state = createModule("state")

lazy val work = createModule(
  "work",
    mainDeps = Seq(
      Dependencies.circeCore.value,
      Dependencies.circeParser.value,
      Dependencies.circeGeneric.value
    )
  )
```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.