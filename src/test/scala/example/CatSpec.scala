package example

import org.scalatest._

class CatSpec extends FlatSpec with Matchers {
  "The Cat object" should "say name" in {
    val cat = new Cat("Oswald", "Black", "Milk")
    cat.greet shouldEqual "hello Oswald"
  }
}
