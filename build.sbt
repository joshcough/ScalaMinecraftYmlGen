import bintray.Keys._

name := "minecraft-sbt-plugin"

lazy val commonSettings = Seq(
  version in ThisBuild := "0.3.5",
  organization in ThisBuild := "com.joshcough"
)

// This project gets published here: http://dl.bintray.com/sbt/sbt-plugin-releases/com.joshcough/
lazy val root = (project in file(".")).
  settings(commonSettings).
  settings(
    sbtPlugin := true,
    name := "minecraft-sbt-plugin",
    sbtVersion := "0.13.8",
    scalaVersion := "2.10.4",
    libraryDependencies += "com.joshcough" %% "scala-minecraft-plugin-api" % "0.3.3",
    scalacOptions ++= Seq(Opts.compile.deprecation),
    description := "automatically generate plugin.yml and config.yml for scala minecraft plugins",
    licenses <++= version(v => Seq("MIT" -> url(
      "https://github.com/joshcough/ScalaMinecraftYmlGen/blob/%s/LICENSE".format(v)))),
    publishMavenStyle := false,
    repository in bintray := "sbt-plugins",
    bintrayOrganization in bintray := None
  )

pomExtra :=
  <scm>
    <url>git@github.com:joshcough/ScalaMinecraftYmlGen.git</url>
    <connection>scm:git:git@github.com:joshcough/ScalaMinecraftYmlGen.git</connection>
  </scm>
  <developers>
    <developer>
      <id>joshcough</id>
      <name>Josh Cough</name>
      <url>https://github.com/joshcough</url>
    </developer>
  </developers>
