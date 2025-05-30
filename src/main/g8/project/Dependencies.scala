import sbt._

object Dependencies {
  object com {
    object eed3si9n {
      object expecty {
        val expecty =
          "com.eed3si9n.expecty" %% "expecty" % "0.17.0"
      }
    }
  }

  object org {
    object scalacheck {
      val scalacheck =
        "org.scalacheck" %% "scalacheck" % "1.18.1"
    }

    object scalameta {
      val munit =
        moduleId("munit")

      val `munit-scalacheck` =
        "org.scalameta" %% "munit-scalacheck" % "1.1.0"

      private def moduleId(artifact: String): ModuleID =
        "org.scalameta" %% artifact % "1.1.1"
    }

    object typelevel {
      val `discipline-munit` =
        "org.typelevel" %% "discipline-munit" % "2.0.0"
    }
  }
}
