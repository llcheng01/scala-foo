package fpinscala

import munit.FunSuite

class Ch2Spec extends FunSuite {
  
 test("mkString should return an empty string for an empty array") {
    val result = Ch2.mkString(Array(), ", ")
    assertEquals(result, "")
  }

  test("mkString should join elements with a separator") {
    val result = Ch2.mkString(Array("Scala", "is", "awesome"), "-")
    assertEquals(result, "Scala-is-awesome")
  }
}
