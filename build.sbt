ThisBuild / scalaVersion     := "3.0.2"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "io.github.vigoo"
ThisBuild / organizationName := "vigoo"

lazy val root = (project in file("."))
  .settings(
    name := "scala3-type-infer-bug",
    scalacOptions += "-Xprint:typer"
  )
