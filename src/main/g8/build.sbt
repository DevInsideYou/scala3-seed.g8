import Dependencies._

ThisBuild / organization := "$organization;format="lower,package"$"
ThisBuild / scalaVersion := "3.0.0-M2"
ThisBuild / version := "0.0.1-SNAPSHOT"

ThisBuild / scalacOptions ++=
  Seq("-rewrite", "-indent") ++ Seq(
    "-deprecation",
    "-feature",
    "-language:implicitConversions",
    "-unchecked",
    "-Xfatal-warnings"
  )

lazy val `$name;format="norm"$` =
  project
    .in(file("."))
    .settings(name := "$name$")
    .settings(commonSettings)
    .settings(dependencies)

lazy val commonSettings = Seq(
  update / evictionWarningOptions := EvictionWarningOptions.empty,
  Compile / console / scalacOptions --= Seq(
    "-Wunused:_",
    "-Xfatal-warnings"
  ),
  Test / console / scalacOptions :=
    (Compile / console / scalacOptions).value
)

lazy val dependencies = Seq(
  libraryDependencies ++= Seq(
    // main dependencies
  ),
  libraryDependencies ++= Seq(
    org.scalatest.scalatest,
    org.scalatestplus.`scalacheck-1-15`
  ).map(_ % Test)
)
