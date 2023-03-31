package $package;format="lower,package"$
package $name;format="lower,word"$

export org.scalacheck.Arbitrary
export org.scalacheck.Cogen
export org.scalacheck.Gen

trait TestSuite extends munit.DisciplineSuite, Expectations
