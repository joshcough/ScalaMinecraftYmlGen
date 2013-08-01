package com.joshcough

import java.io.File
import sbt._
import Keys._
import jcdc.pluginfactory.YMLGenerator._

object Plugin extends sbt.Plugin {

  def pluginYmlSettings(author: String): Seq[Setting[_]] = Seq[Setting[_]](
    resourceGenerators in Compile <+=
      (resourceManaged in Compile, streams, name, productDirectories in Compile, dependencyClasspath in Compile, version, compile in Compile, runner) map {
        (dir, s, name, cp1, cp2, v, _, r) =>
          Run.run(
            "jcdc.pluginfactory.YMLGenerator", (Attributed.blankSeq(cp1) ++ cp2).map(_.data),
            Seq("jcdc.pluginfactory.examples." + name, author, v, dir.getAbsolutePath),
            s.log)(r)
          Seq(dir / "plugin.yml", dir / "config.yml")
      }
  )

}
