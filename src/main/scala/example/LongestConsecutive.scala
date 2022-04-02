package example

object LongestConsecutive extends App {

//  def brute(nums: Array[Int]): Option[Int] = {
//    for (
//      (a_i, i) <- nums.view.zipWithIndex
//      subViewToTest = nums.view.drop(i + 1).filter(v => v > a_i)
//      result = brute(subViewToTest.toArray)
//    ) yield result.getOrElse(0) + 1
//  }.maxOption

  def lengthOfLongestSubstring(s: String): Int = {
    s.scanLeft("")((currStr: String, currChar: Char) =>
      currStr.substring(1 + currStr.indexOf(currChar.toString)) + currChar)
      // Up to this point we would get vector like this
      // Vector(, a, ab, abc, bca, cab, abc, cb, b)
      // now if we take max of length would get the answer
      .map(_.length)
      .reduce(Math.max)
  }
  // "aab".scanLeft("") { (currStr: String, currChar: Char) => println(s"str: ${currStr} char: ${currChar}"); currStr.substring(1 + currStr.indexOf(currChar)) + currChar }
  //str:  char: a
  //str: a char: a
  //str: a char: b
  //res60: collection.immutable.IndexedSeq[String] = Vector("", "a", "a", "ab")

  def withSorting(nums: Array[Int]): Int = {
    if (nums.length == 0) {
      return 0
    }
    val sorted = nums.sortWith(_ > _)

    var longestStreak = 1
    var currentStreak = 1

    for (i <- 1 until sorted.length) {
      if (sorted(i - 1) != sorted(i)) {
        if (sorted(i - 1) + 1 == sorted(i)) {
          currentStreak += 1
        } else {
          longestStreak = math.max(currentStreak, longestStreak)
          currentStreak = 1
        }
      }
    }
    Math.max(longestStreak, currentStreak)
  }

  def flattenStringArrays[A](arr: Array[A]): Array[String] =
    arr.flatMap {
      case s: String => Array(s)
      case a: Array[_] => flattenStringArrays(a)
    }

  def process(nums: Array[Int]): Int = {
    // val isCons = (a: Int, b: Int) => (a - b).abs == 1
    val sorted = nums.sortWith(_ < _)
    sorted.head

  }
//    def longestConsecutive(nums: Array[Int]): Int = {
//
//      var max = 0
//      var maxLen = 0
//
//      def loop(arr: Array[Int], pos: Int, last: Int): Int = {
//        if (pos == arr.length) 0
//        else {
//          var t1 = 0
//          var t2 = 0
//          if (arr(pos) > last)
//            t1 = 1 + loop(arr, pos+1, arr(pos))
//          else {
//            t2 = loop(arr, pos+1, last)
//          }
//          max = Math.max(t1, t2)
//          max
//        }
//      }
//      import collection.generic.CanBuildFrom
//
//      for (
//        (a_i, i) <- nums.view.zipWithIndex;
//        var len = loop(nums, i + 1, nums[i]);
//        if (len > maxLen) {
//          maxLen = len
//        }
//      ) yield len.getElse(0) + 1
//
//      maxLen + 1
//    }

  // https://stackoverflow.com/questions/52418606/find-all-possible-increasing-subsequences-of-a-given-length-in-scala

  // "aab".scanLeft("") { (currStr: String, currChar: Char) => println(s"str: ${currStr} char: ${currChar}"); currStr.substring(1 + currStr.indexOf(currChar)) + currChar }
}
