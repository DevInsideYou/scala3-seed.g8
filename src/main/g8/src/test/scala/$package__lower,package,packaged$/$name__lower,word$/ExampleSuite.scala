package $package;format="lower,package"$
package $name;format="lower,word"$

final class ExampleSuite extends TestSuite:
  test("hello world"):
    forAll: (int: Int, string: String) =>
      expectEquals(int, int)
      expectEquals(string, string)
