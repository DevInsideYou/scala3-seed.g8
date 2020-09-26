import sbt._

object Dependencies {
  case object org {
    case object scalatest {
      val scalatest =
        "org.scalatest" %% "scalatest" % "3.2.2"
    }

    case object scalatestplus {
      val `scalacheck-1-14` =
        "org.scalatestplus" %% "scalacheck-1-14" % "3.2.2.0"
    }
  }
}
