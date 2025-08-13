package fpinscala

object Ch5 {
  sealed trait MyStream[+A]
  case object MyEmpty extends MyStream[Nothing]
  case class MyCons[+A](h: () => A, t: () => MyStream[A]) extends MyStream[A]
  // object MyStream {
  //     def cons[A](hd: => A, tl: => MyStream[A]): MyStream[A] = {
  //         lazy val head = hd
  //         lazy val tail = tl
  //         MyCons()
  //     }
  // }
}
