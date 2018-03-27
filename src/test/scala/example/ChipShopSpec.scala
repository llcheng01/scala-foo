package example

import org.scalatest._

class ChipShopSpec extends FlatSpec with Matchers {
    "Cat who like chips" should "return true when ChipShop.willServe" in {
        ChipShop.willServe(new Cat("Henry", "Ginger", "Chips")) should be (true)
    }
    "Cat who does not like chip ChipShop willServe" should "return false when ChipShop.willServe" in {
        ChipShop.willServe(new Cat("Joe", "spotted", "Fish")) should be (false) 
    }
}
