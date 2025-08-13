error id: file://<WORKSPACE>/src/test/scala/Ch6Spec.scala:`<none>`.
file://<WORKSPACE>/src/test/scala/Ch6Spec.scala
empty definition using pc, found symbol in pc: `<none>`.
semanticdb not found
empty definition using fallback
non-local guesses:
	 -munit.
	 -scala/Predef.munit.
offset: 26
uri: file://<WORKSPACE>/src/test/scala/Ch6Spec.scala
text:
```scala
package fpinscala

import @@munit.FunSuite

class Ch6Spec extends FunSuite {
  import Ch6._

  val rng50 = SimpleRNG(50)

  test("sequence should have switch the Rand and List type") {
    // trampoline problem in Part 4??
    // val randInts: List[Rand[Int]] = List.fill(5)(_.nextInt)
    // val randList: Rand[List[Int]] = sequence(randInts)

  }

  test("flatMap") {
    val evenNumber: Rand[Int] = flatMap(nonNegativeInt)(n => rng => (n - n % 2, rng))

    val (even, _) = evenNumber(rng50)

    assert(even % 2 == 0)
  }

  test("simulateMachine") {
  
    val initialMachine = Machine(locked = true, candies = 5, coins = 10)
    val testInputs = List(Coin, Turn, Coin, Turn)

    val runMachine = simulateMachine(testInputs)

    // Apply the transformation to the initial state
    // val ((finalCandies, finalCoins), finalMachine)
    val ((finalCandies, finalCoins), _) = runMachine(initialMachine)

    assertEquals(finalCoins, 12)
    assertEquals(finalCandies, 3)
  }

}

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.