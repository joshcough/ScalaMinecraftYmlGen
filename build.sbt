organization := "com.joshcough"

name := "scala-minecraft-yml-gen"

version := "0.3.1"

description := "automatically generate plugin.yml and config.yml for scala minecraft plugins"

sbtPlugin := true

sbtVersion := "0.13.0-RC4"

scalaVersion := "2.10.2"

libraryDependencies += "com.joshcough" %% "scala-minecraft-plugin-api" % "0.3.1"

scalacOptions ++= Seq(Opts.compile.deprecation)

licenses <++= (version)(v => Seq("MIT" -> url(
  "https://github.com/joshcough/ScalaMinecraftYmlGen/blob/%s/LICENSE".format(v))))

publishMavenStyle := true

publishArtifact in Test := false

seq(bintraySettings:_*)
