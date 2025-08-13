package fpinscala

import munit.FunSuite

class Ch8Spec extends FunSuit {
  test("Property List reverse has its own value") {
    val listGen = Gen.listOfN(3, Gen.choose(1, 10))
    val prop = Prop.forAll(listGen) { list =>
        list.reverse.reverse === list
    }

    prop.check match {
        case Right(successCount) => assert(successCount > 0)
        case Left((failMessg, _)) -> fail(s"Something wrong: ${failMessg}")
    }
  }
}
