package fpinscala

import munit.FunSuite

class Ch3Spec extends FunSuite {
    import Ch3._

    val xs: LinkedList[Int] = Nil
    val ys: LinkedList[Int] = Cons[Int](2, xs)
    val zs: LinkedList[Int] = Cons[Int](3, ys)
    val zs4: LinkedList[Int] = Cons[Int](4, zs)
    val zs5: LinkedList[Int] = Cons[Int](5, zs4)
    val zs6: LinkedList[Int] = Cons[Int](6, zs5)

    val ds: LinkedList[Double] = Nil
    val ds5: LinkedList[Double] = Cons[Double](5.0, ds)
    val ds2: LinkedList[Double] = Cons[Double](2.0, ds5)
    val ds0: LinkedList[Double] = Cons[Double](0.0, ds5)

    test("sum should add all integers to a total") {
        val result = LinkedList.sum(zs)
        assertEquals(result, 5)
    }

    test("product should multiple to correct double number") {
        val result = LinkedList.product(ds2)
        assertEquals(result, 10.0)
    }

    test("product should multiple 0.0") {
         val result = LinkedList.product(ds0)
         assertEquals(result, 0.0) 
    }

    test("tail should remove n number of elements") {
        val result = LinkedList.drop(zs6, 1)
        assertEquals(4, result.length)
    }

    test("tail should return original Linked List if n is less than or equals zero") {
        val result = LinkedList.drop(zs6, 0)
        assertEquals(5, result.length)
    }

    test("dropWhile should filter out odd element") {
        val oddFilter: Int => Boolean = (x) => x % 2 == 0
        val result = LinkedList.dropWhile(zs6, oddFilter)
        assertEquals(4, result.length) // Only do it once!!
    }

    test("init would not return the last element") {
        val xs: LinkedList[Int] = Nil
        val xs1: LinkedList[Int] = Cons[Int](1, xs)
        val xs2: LinkedList[Int] = Cons[Int](2, xs1)
        val xs3: LinkedList[Int] = Cons[Int](3, xs2)

        val result = LinkedList.init(xs3)
        assertEquals(Cons(3, Cons(2, Nil)), result)
    }

}