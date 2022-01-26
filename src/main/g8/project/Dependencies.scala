import sbt._

object Dependencies {
  object org {
    object scalatest {
      val scalatest =
        "org.scalatest" %% "scalatest" % "3.2.11"
    }

    object scalatestplus {
      val `scalacheck-1-15` =
        "org.scalatestplus" %% "scalacheck-1-15" % "3.2.11.0"
    }
  }
}
