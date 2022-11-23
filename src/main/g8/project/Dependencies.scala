import sbt._

object Dependencies {
  object com {
    object eed3si9n {
      val expecty =
        "com.eed3si9n.expecty" %% "expecty" % "0.16.0"
    }
  }

  object org {
    object scalatest {
      val scalatest =
        "org.scalatest" %% "scalatest" % "3.2.14"
    }

    object scalatestplus {
      val `scalacheck-1-16` =
        "org.scalatestplus" %% "scalacheck-1-16" % "3.2.14.0"
    }
  }
}
