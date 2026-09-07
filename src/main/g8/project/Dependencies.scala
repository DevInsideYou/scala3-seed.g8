import sbt._

object Dependencies {
  object com {
    object eed3si9n {
      object expecty {
        val expecty =
          "com.eed3si9n.expecty" %% "expecty" % "0.17.1"
      }
    }
  }

  object org {
    object scalacheck {
      val scalacheck =
        "org.scalacheck" %% "scalacheck" % "1.20.0"
    }

    object scalameta {
      val munit =
        moduleId("munit")

      val `munit-scalacheck` =
        "org.scalameta" %% "munit-scalacheck" % "1.3.1"

      private def moduleId(artifact: String): ModuleID =
        "org.scalameta" %% artifact % "1.3.6"
    }

    object typelevel {
      val `discipline-munit` =
        "org.typelevel" %% "discipline-munit" % "2.0.0"
    }
  }
}
