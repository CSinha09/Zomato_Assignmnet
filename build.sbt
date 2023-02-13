ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.11.0"

lazy val root = (project in file("."))
  .settings(
    name := "zomato_assignment"
  )

libraryDependencies += "com.github.tototoshi" %% "scala-csv" % "1.3.7"
