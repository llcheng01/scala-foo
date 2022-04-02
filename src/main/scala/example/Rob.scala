package example

object Rob extends App {
  import java.lang.Math

  def rob(n: Array[Int]): Int = {
    if (n.length == 1)
      return n(0)
    else if (n.length == 2)
      return Math.max(n(1), n(0))

    var case1 = n(0)
    var case2 = Math.max(n(0), n(1))
    var sum = 0

    for (x <- 2 to n.length) {
      sum = Math.max(case1 + n(x), case2)
      case1 = case2
      case2 = sum
    }
    sum
  }

//  def rob1(n: Array[Int]) = {
//    var result = scala.collection.mutable.Map[Int, Int]()
//
//    def loop(cur:Int): Int = {
//      if (n.length == 1)
//        return n(0)
//      else if (n.length == 2)
//        return Math.max(n(1), n(0))
//
//      if (result.contains(cur)) {
//        result(cur) = Math.max(loop(n -2 ) + n(cur), loop(n-1))
//      }
//      result(cur)
//    }
//    loop(n.length - 1)
//  }
}
