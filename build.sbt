lazy val commonSettings = Seq(
  organization := "com.alex",
  version := "1.0",
  scalaVersion := "2.11.8"
)

libraryDependencies ++= Seq(
	"org.apache.spark" %% "spark-core" % "2.2.0",
	"org.specs2" % "specs2_2.11" % "3.7" % "test"
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
	name := "spark-example",
	fork in run := true,
	javaOptions += "-Xmx4G"
  )
