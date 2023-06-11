ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.3.0"
ThisBuild / maintainer := "SinarPandora@outlook.com"
ThisBuild / scalacOptions ++= Seq(
  "-Wunused:all",
  "-Wvalue-discard"
)

lazy val root = (project in file("."))
  .settings(
    name := "JamNext"
  )
  .aggregate(
    goCQProtocol,
    cqServer,
    jam
  )

lazy val goCQProtocol = (project in file("protocol"))
  .settings(
    name := "GoCQProtocol",
    libraryDependencies ++= zioCore ++ shttp
  )

lazy val cqServer = (project in file("CQServer"))
  .settings(
    name := "GoCQServer",
    libraryDependencies ++= zioCore ++ zioHttp ++ shttp
  )
  .dependsOn(goCQProtocol)

lazy val jam = (project in file("Jam"))
  .settings(
    name := "Jam",
    libraryDependencies ++= zioCore ++ zioHttp ++ config ++ shttp,
    addCommandAlias("build", ";scalafmtAll;compile;"),
    addCommandAlias("dist", ";clean;scalafmtAll;universal:packageBin;")
  )
  .enablePlugins(JavaServerAppPackaging)
  .dependsOn(cqServer)

lazy val zioCore = Seq(
  "dev.zio" %% "zio" % "2.0.15",
  "dev.zio" %% "zio-direct" % "1.0.0-RC7"
)

lazy val zioHttp = Seq(
  "dev.zio" %% "zio-http" % "3.0.0-RC2",
  "dev.zio" %% "zio-json" % "0.5.0"
)

lazy val config = Seq(
  "dev.zio" %% "zio-config" % "4.0.0-RC16",
  "dev.zio" %% "zio-config-typesafe" % "4.0.0-RC16"
)

lazy val shttp = Seq(
  "com.softwaremill.sttp.client3" %% "core",
  "com.softwaremill.sttp.client3" %% "zio",
  "com.softwaremill.sttp.client3" %% "zio-json"
).map(_ % "3.8.15")
