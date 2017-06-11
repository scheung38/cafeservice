name := "cafeservice"

organization := "com.fortressgain"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.11.2"


scalacOptions := Seq("-unchecked", "-feature", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" %"3.0.1",
  "org.scalatest" %% "scalatest" %"3.0.1" % Test
)

// run scalastyl e at compile time
lazy val compileScalastyle = taskKey[Unit]("compileScalastyle")

compileScalastyle := org.scalastyle.sbt.ScalastylePlugin.scalastyle.in(Compile).toTask("").value

(compile in Compile) <<= (compile in Compile) dependsOn compileScalastyle

// code coverage configuration
coverageEnabled := false

coverageHighlighting := true

coverageMinimum := 100

coverageFailOnMinimum := true

parallelExecution in Test := false