package com.joshcough.minecraft

import sbt._
import Keys._
import java.io.File

object Plugin extends sbt.Plugin {

  def pluginYmlSettings(pluginClassname: String, author: String): Seq[Setting[_]] = Seq[Setting[_]](
    resourceGenerators in Compile <+=
      (resourceManaged in Compile, streams, productDirectories in Compile, dependencyClasspath in Compile, version, compile in Compile, runner) map {
        (dir, s, cp1, cp2, v, _, r) =>
          Run.run(
            "com.joshcough.minecraft.YMLGenerator", (Attributed.blankSeq(cp1) ++ cp2).map(_.data),
            Seq(pluginClassname, author, v, dir.getAbsolutePath),
            s.log)(r)
          Seq(dir / "plugin.yml", dir / "config.yml")
      }
  )

  def copyPluginToBukkitSettings(meta: Option[String]) = Seq(
    // make publish local also copy jars to my bukkit server :)
    publishLocal <<= (packagedArtifacts, publishLocal) map { case (r, _) =>
      r collectFirst { case (Artifact(_,"jar","jar", m, _, _, name), f) if m == meta =>
        println("copying " + f.name + " to bukkit server")
        IO.copyFile(f, new File("bukkit/plugins/" + f.name))
      }
    }
  )

  def join(settings: Seq[Def.Setting[_]]*) = settings.flatten
  def named(pname: String) = Seq(name := pname)
  def libDeps(libDeps: sbt.ModuleID*) = Seq(libraryDependencies ++= libDeps)
}
