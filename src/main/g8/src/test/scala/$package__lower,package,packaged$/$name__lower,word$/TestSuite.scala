package $package;format="lower,package"$
package $name;format="lower,word"$

import org.scalatest.*
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

export com.eed3si9n.expecty.Expecty.expect
export org.scalacheck.Arbitrary
export org.scalacheck.Gen
export org.scalatest.compatible.Assertion

trait TestSuite
    extends AnyFunSuite,
            should.Matchers,
            GivenWhenThen,
            BeforeAndAfterAll,
            BeforeAndAfterEach,
            ScalaCheckPropertyChecks
