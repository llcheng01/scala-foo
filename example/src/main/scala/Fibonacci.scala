package example

object Fibonacci extends App {

  def fib(n: Int): Int = {
    def go(n: Int): Int =
      n match {
        case x if x == 0 => 0
        case x if x == 1 => 1
        case _ => go(n -1) + go(n-2)
      }

    go(n)
  }
  //    @annotation.tailrec
  def tribonacci(n: Int): Int = {
    @annotation.tailrec
    def go(n: Int, prev: Int, cur: Int): Int =
      n match {
        case x if x == 0 => prev
        case _ => go(n-1, cur, prev + cur)
      }
    go(n, 0, 1)
  }
}
