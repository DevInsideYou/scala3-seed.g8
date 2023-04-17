package $package;format="lower,package"$
package $name;format="lower,word"$

import scala.Console.*

import com.eed3si9n.expecty.Expecty
import munit.internal.console.StackTraces.dropInside

trait Expectations:
  this: munit.FunSuite =>
  inline def expect(
    inline cond: Boolean,
    clue: => Any = "assertion failed",
  )(using
    loc: munit.Location
  ): Unit =
    lazy val calculatedClue =
      val expectyClue =
        try { Expecty.assert(cond); "" }
        catch Expectations.ExtractMessage

      if expectyClue.isEmpty then s"\$RED\n\$clue\$RESET"
      else s"\$RED\n\$clue\n\$expectyClue\$RESET"

    assert(cond, calculatedClue)

  def expectEquals[A, B](
    obtained: A,
    expected: B,
    clue: => Any = "values are not the same",
  )(using
    loc: munit.Location,
    ev: B <:< A,
  ): Unit =
    lazy val calculatedClue =
      val expectyClue =
        try { Expecty.assert(obtained == expected); "" }
        catch Expectations.ExtractMessage

      if expectyClue.isEmpty then s"\$RED\n\$clue\$RESET"
      else s"\$RED\n\$clue\n\$expectyClue\$RESET"

    assertEquals(obtained, expected, calculatedClue)

  def expectNotEquals[A, B](
    obtained: A,
    expected: B,
    clue: => Any = "values are the same",
  )(using
    loc: munit.Location,
    ev: A =:= B,
  ): Unit =
    lazy val calculatedClue =
      val expectyClue =
        try { Expecty.assert(obtained != expected); "" }
        catch Expectations.ExtractMessage

      val clueWithSuffix =
        s"\${munitPrint(clue)} expected same: \$expected was not: \$obtained"

      if expectyClue.isEmpty then clueWithSuffix
      else s"\$RED\n\$clueWithSuffix\n\$expectyClue\$RESET"

    dropInside(if obtained == expected then failComparison(calculatedClue, obtained, expected))

object Expectations:
  private val ExtractMessage: PartialFunction[Throwable, String] =
    case e: AssertionError =>
      // it's in a try/catch because of .nn
      try e.getMessage.nn.split("\n").nn.slice(2, Int.MaxValue).mkString("\n", "\n", "\n")
      catch case scala.util.control.NonFatal(_) => ""
