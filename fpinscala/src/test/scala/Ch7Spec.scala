package fpinscala

import munit.FunSuite
import java.util.concurrent.Executors

class Ch7Spec extends FunSuite {
    import Ch7._
  
    val es = Executors.newFixedThreadPool(4)

    test("unit should wrap value into a Par") {
        val p = Par.unit(10)
        assertEquals(Par.run(es)(p).get(), 10)
    }

    test("map2 should combine two Par values") {
        val a = Par.unit(5)
        val b = Par.unit(3)
        val result = Par.map2(a, b)(_ + _)
        assertEquals(Par.run(es)(result).get(), 8)
    }

    test("sum should return correct result") {
        // import Ch7.Examples._

        val numbers = IndexedSeq(1, 3, 4, 5)
        val result = Par.run(es)(Ch7.Examples.sum(numbers)).get()

        assertEquals(result, 13)
    }

}