import sbt._

object Dependencies {
  object com {
    object eed3si9n {
      object expecty {
        val expecty =
          "com.eed3si9n.expecty" %% "expecty" % "0.16.0"
      }
    }
  }

  object org {
    object scalacheck {
      val scalacheck =
        "org.scalacheck" %% "scalacheck" % "1.17.0"
    }

    object scalameta {
      val munit =
        moduleId("munit")

      val `munit-scalacheck` =
        moduleId("munit-scalacheck")

      private def moduleId(artifact: String): ModuleID =
        "org.scalameta" %% artifact % "0.7.29"
    }

    object typelevel {
      val `discipline-munit` =
        "org.typelevel" %% "discipline-munit" % "1.0.9"
    }
  }
}
