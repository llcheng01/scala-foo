package fpinscala

import scala.annotation.tailrec

object Ch2 {
  def curry[A, B, C](f: (A, B) => C): A => (B => C) = 
    (a: A) => (b: B) => f(a, b)

  def uncurry[A, B, C](f: A => B => C): (A, B) => C = 
    (a: A, b: B) => f(a)(b)

  def add: (Int, Int) => Int = (x, y) => x + y

  val threePlus: Int => Int = (x) => x + 3

  val curryAdd: Int => (Int => Int) = curry(add)

  // val fivePlus3 = curryAdd(5)(3)

  def compose[A, B, C](f: B => C, g: A => B): A => C = 
    a => f(g(a))

  def mkString(strings: Array[String], separator: String): String = {
    @tailrec
    def loop(stringList: List[String], result: String): String = {
      stringList match {
        case Nil => result
        case head :: Nil => result + head 
        case head::tail => loop(tail, result + head + separator)
      }
    }
    loop(strings.toList, "")
  }
  
}
