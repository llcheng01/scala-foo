package example

object ClimbStairs extends App {
  def climbStairs(n: Int): Int = {
    def loop(n: Int): Int = {
      n match {
        case i if i == 1 => 1
        case j if j == 2 => 2
        case _ => loop(n - 1) + loop(n-2)
      }
    }
    loop(n)
  }
}
