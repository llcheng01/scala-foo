package fpinscala

import munit.FunSuite

class Ch3TreeSpec extends FunSuite {
  import Ch3Tree._

  val tree1: Tree[Int] = Branch(Leaf(3), Leaf(5))
  val tree2: Tree[Int] = Branch(Leaf(2), Leaf(8))

  test("Tree should be able to compare") {

    assert(implicitly[Ordering[Tree[Int]]].gt(tree1, tree2))
  }

  test("Tree should find the maximum value leaf") {
    val tree: Tree[Int] = Branch(Leaf(3), Branch(Leaf(10), Leaf(5)))

    assertEquals(10, maximum(tree))
  }
}
