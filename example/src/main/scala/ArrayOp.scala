package example

object ArrayOp extends App {

  // Count frequency by count and secondarily by id
  def countFreq(nums: Array[Int]) = {
    val countOfMap = nums.groupBy(identity).mapValues(_.size)

    countOfMap.toList.sortWith(_._2 > _._2)

    //    val ids = List(23,1,3,22,5,23,1,23)
//    var idMap = scala.collection.mutable.Map[Int, Int]()
//    var count = 0
//    for (x <- ids) {
//      // current if exist in map key
//      idMap.get(x) match {
//        case Some(v) =>
//          idMap(v, count + 1)
//        case None =>
//          idMap(x, 1)
//      }


      // SELECT id, count(*) FROM XX
      // group by id DESC
      // aggregration

      //
      // To sort the result again. It wiil
      // have to group by count/frequency again
      // and sort by id

      // if (idMap.contains(x)) {
      //   count = map.get(id)
      //   idMap(x, count + 1)
      // } else {
      //   idMap(x, 1)
      // }
    }
    //    idMap.sort(_.value)
    //
    //    idMap.map(println(k, v))

  }

//  def findMissing(numbers: List[Int]) = {
//    var result: Map[Int, Int] = collections.mutable.Map[Int, Int]()
//
//    val numbersArr = numbers.toArray
//    // Initialize the map
//    for (x <- numberArr.withIndex) {
//      result(x) = 0
//    }
//
//
//    for (y <- numbers) {
//      if (result.keySet().contains(y))
//        result(y) = 1
//    }
//
//    result.reduce(_ == 0)
//  }


//  numbers.sorted.scanLeft(0)((acc, cur) => val prev = acc; cur - prev == 1 )
//
//  def loop(numbers: List, map: Map.Empty()):Map {
//
//    val numberArr = numbers.toArray
//
//    if (numbers.length == 0)
//      return map
//
//    if (!map.contains())
//      map(numbers.remove()) =1
//
//    loop(numbers, map)
//
//  }.reduce(_ == 0)
