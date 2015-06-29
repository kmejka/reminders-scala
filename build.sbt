name := "reminders-scala"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies += "com.massrelevance" %% "dropwizard-scala" % "0.7.1"
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0"

//TEST DEPENDENCIES
libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"
libraryDependencies += "junit" % "junit" % "4.10" % "test"
