organization := "com.joshcough"

name := "scala-minecraft-yml-gen"

version := "0.3.1"

description := "automatically generate plugin.yml and config.yml for scala minecraft plugins"

sbtPlugin := true

sbtVersion := "0.13.0-RC4"

scalaVersion := "2.10.2"

seq(bintrayResolverSettings:_*)

libraryDependencies += "com.joshcough" %% "scala-minecraft-plugin-api" % "0.3.1"

scalacOptions ++= Seq(Opts.compile.deprecation)

licenses <++= (version)(v => Seq("MIT" -> url(
  "https://github.com/joshcough/ScalaMinecraftYmlGen/blob/%s/LICENSE".format(v))))

publishTo := Some(Resolver.url("sbt-plugin-releases-xxx", new URL("http://repo.scala-sbt.org/scalasbt/sbt-plugin-releases/"))(Resolver.ivyStylePatterns))

publishMavenStyle := false

publishArtifact in Test := false

pomExtra := (
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
)

