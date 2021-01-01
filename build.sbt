import Dependencies._

ThisBuild / scalaVersion     := "2.13.4"
ThisBuild / version          := "0.1.0"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val shared = (project in file("shared"))
  .settings(
    name := "shared"
  )

lazy val ce3 = (project in file("ce3"))
  .settings(
    name := "ce3-benchmark",
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-effect" % "3.0.0-M5",
      scalaTest % Test)
  ).dependsOn(shared)

lazy val ce2 = (project in file("ce2"))
  .settings(
    name := "ce2-benchmark",
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-effect" % "2.3.1"
    )
  ).dependsOn(shared)

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
