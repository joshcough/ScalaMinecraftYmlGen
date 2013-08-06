package com.joshcough.minecraft

import java.io.File
import sbt._
import Keys._
import com.joshcough.minecraft.YMLGenerator._

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
}
