error id: file://<WORKSPACE>/fpinscala/src/test/scala/Ch7Spec.scala:`<none>`.
file://<WORKSPACE>/fpinscala/src/test/scala/Ch7Spec.scala
empty definition using pc, found symbol in pc: `<none>`.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -Ch7.unit.
	 -Ch7.unit#
	 -Ch7.unit().
	 -unit.
	 -unit#
	 -unit().
	 -scala/Predef.unit.
	 -scala/Predef.unit#
	 -scala/Predef.unit().
offset: 241
uri: file://<WORKSPACE>/fpinscala/src/test/scala/Ch7Spec.scala
text:
```scala
package fpinscala

import munit.FunSuite
import java.util.concurrent.Executor

class Ch7Spec extends FunSuite {
    import Ch7._
  
    val es = Executor.newFixedThreadPool(4)

    test("unit should wrap value into a Par") {
        val p = @@unit(10)
        assertEquals(Par.run(es)(p).get(), 10)
    }

    test("map should apply function inside Par") {
        val p = map(unit(10))(_ * 2)
        assertEquals(Par.run(es)(p).get(), 20)
    }

    test("map2 should combine two Par values") {
        val a = unit(5)
        val b = unit(3)
        val result = map2(a, b)(_ + _)
        assertEquals(Par.run(es)(p).get(), 8)
    }

    test("sum should return correct result") {
        import Ch7.Examples._

        val numbers = IndexedSeq(1, 3, 4, 5)
        val result = Par.run(es)(sum(numbers)).get()

        assertEquals(result, 13)
    }

}

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.