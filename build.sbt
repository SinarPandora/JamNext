ThisBuild / version      := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.3.0"
ThisBuild / maintainer   := "SinarPandora@outlook.com"
ThisBuild / scalacOptions ++= Seq(
  "-Wunused:all",
  "-Wvalue-discard"
)
ThisBuild / scalacOptions += Seq(
  "java.lang",
  "scala",
  "scala.Predef",
  "scala.annotation",
  "scala.util.chaining",
  "zio"
).mkString(start = "-Yimports:", sep = ",", end = "")

addCompilerPlugin("com.hmemcpy" %% "zio-clippy" % "0.0.1")

lazy val root = (project in file("."))
  .settings(
    name := "JamNext"
  )
  .aggregate(
    GoCQProtocol,
    CQServer,
    SXDLParser,
    Jam
  )

lazy val GoCQProtocol = (project in file("Protocol"))
  .settings(
    name := "GoCQProtocol",
    libraryDependencies ++= zioCore ++ shttp
  )

lazy val CQServer = (project in file("CQServer"))
  .settings(
    name := "GoCQServer",
    libraryDependencies ++= zioCore ++ zioHttp ++ shttp
  )
  .dependsOn(GoCQProtocol)

lazy val SXDLParser = (project in file("SXDLParser"))
  .settings(
    name := "SXDLParser",
    libraryDependencies ++= zioCore
  )

lazy val Jam = (project in file("Jam"))
  .settings(
    name := "Jam",
    libraryDependencies ++= zioCore ++ zioHttp ++ config ++ shttp,
    addCommandAlias("build", ";scalafmtAll;compile;"),
    addCommandAlias("dist", ";clean;scalafmtAll;universal:packageBin;")
  )
  .enablePlugins(JavaServerAppPackaging)
  .dependsOn(
    SXDLParser,
    CQServer
  )

val ZIO_CORE = "2.0.15"
val SHTTP    = "3.8.15"

lazy val zioCore = Seq(
  "dev.zio" %% "zio"         % ZIO_CORE,
  "dev.zio" %% "zio-direct"  % "1.0.0-RC7",
  "dev.zio" %% "zio-prelude" % "1.0.0-RC19"
)

lazy val zioHttp = Seq(
  "dev.zio"                       %% "zio-http" % "3.0.0-RC2",
  "dev.zio"                       %% "zio-json" % "0.5.0",
  "com.softwaremill.sttp.client3" %% "zio"      % SHTTP
)

lazy val config = Seq(
  "dev.zio" %% "zio-config"          % "4.0.0-RC16",
  "dev.zio" %% "zio-config-typesafe" % "4.0.0-RC16"
)

lazy val shttp = Seq(
  "com.softwaremill.sttp.client3" %% "core",
  "com.softwaremill.sttp.client3" %% "zio-json"
).map(_ % SHTTP)
