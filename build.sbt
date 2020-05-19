name := "scalatest"

version := "0.1"

scalaVersion := "2.13.2"

scalacOptions ++= Seq( "-deprecation", "-feature", "-language:postfixOps", "-language:implicitConversions", "-language:existentials" )

libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.2" % Test
libraryDependencies += "org.scalatestplus" %% "scalacheck-1-14" % "3.1.1.1" % Test
libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.14.3" %  Test
