import bintray.Keys._

organization := "com.joshcough"

name := "minecraft-sbt-plugin"

version := "0.3.3"

description := "automatically generate plugin.yml and config.yml for scala minecraft plugins"

sbtPlugin := true

sbtVersion := "0.13.2"

scalaVersion := "2.10.3"

libraryDependencies ++= Seq(
  "com.joshcough" %% "scala-minecraft-plugin-api" % "0.3.3"
)

scalacOptions ++= Seq(Opts.compile.deprecation)

bintrayPublishSettings

repository in bintray := "sbt-plugins"

bintrayOrganization in bintray := None

licenses <++= version(v => Seq("MIT" -> url(
  "https://github.com/joshcough/ScalaMinecraftYmlGen/blob/%s/LICENSE".format(v))))

publishMavenStyle := false

publishArtifact in Test := false

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

