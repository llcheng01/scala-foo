error id: file://<WORKSPACE>/fpinscala/src/main/scala/Ch7.scala:[375..382) in Input.VirtualFile("file://<WORKSPACE>/fpinscala/src/main/scala/Ch7.scala", "package fpinscala

import java.util.concurrent._

object Ch7 {

  // trait Par[+A] {
  //   def map[B](f: A => B): Par[B] = this match {
  //       case MapPar(par, g) => MapPar(par, g andThen f)
  //       case _ => MapPar(this, f)
  //   }
  // }

  // case class MapPar[A, +B](par: Par[A], f: A => B) extends Par[B]
  type Par[A] = ExecutorService => Future[A]

  def 

  private case class UnitFuture[A](get: A) extends Future[A] {
    def isDone = true
    def get(timeout: Long, units: TimeUnit) = get
    def isCancelled = false
    def cancel(evenIfRunning: Boolean): Boolean = false
  }



  def sum(ints: IndexedSeq[Int]): Int = 
    if (ints.size <= 1)
      ints.headOption.getOrElse(0)
    else {
      val (l,r) = ints.splitAt(ints.length / 2)
      val sumL: Par[Int] = Par.unit(sum(l))
    }
}")
file://<WORKSPACE>/file:<WORKSPACE>/fpinscala/src/main/scala/Ch7.scala
file://<WORKSPACE>/fpinscala/src/main/scala/Ch7.scala:19: error: expected identifier; obtained private
  private case class UnitFuture[A](get: A) extends Future[A] {
  ^
#### Short summary: 

expected identifier; obtained private