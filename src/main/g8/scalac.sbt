import Scalac.Keys._

ThisBuild / scalacOptions ++= Seq(
  "-Wunused:imports", // always on for OrganizeImports
  "-Yexplicit-nulls",
  "-Xkind-projector",
  "-Wsafe-init",
  "-language:all",
) ++
  Seq("-encoding", "UTF-8") ++
  Seq("-rewrite", "-indent") ++
  Seq("-source", "future-migration") ++
  warnings.value ++
  lint.value

ThisBuild / warnings := {
  if (insideCI.value)
    Seq(
      "-Wconf:any:error", // for scalac warnings
      "-Xfatal-warnings", // for wartremover warts
    )
  else if (lintOn.value)
    Seq("-Wconf:any:warning")
  else
    Seq("-Wconf:any:silent")
}

ThisBuild / lintOn :=
  !sys.env.contains("LINT_OFF")

ThisBuild / lint := {
  if (shouldLint.value)
    Scalac.Lint
  else
    Seq.empty
}

ThisBuild / shouldLint :=
  insideCI.value || lintOn.value

ThisBuild / wartremoverWarnings := {
  if (shouldLint.value)
    Seq.empty
  else
    (ThisBuild / wartremoverWarnings).value
}
