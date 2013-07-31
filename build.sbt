organization := "jcdc.pluginfactory"

name := "scala-minecraft-yml-gen"

version := "0.3.1"

description := "automatically generate plugin.yml and config.yml for scala minecraft plugins"

sbtPlugin := true

sbtVersion in Global := "0.13.0-RC4"

scalaVersion in Global := "2.10.2"

libraryDependencies += "jcdc.pluginfactory" %% "scala-minecraft-plugin-api" % "0.3.1"

scalacOptions ++= Seq(Opts.compile.deprecation)

licenses <++= (version)(v => Seq("MIT" -> url(
  "https://github.com/joshcough/scala-minecraft-yml-gen/blob/%s/LICENSE".format(v))))

publishTo := Some(Classpaths.sbtPluginReleases)

publishMavenStyle := false

publishArtifact in Test := false

