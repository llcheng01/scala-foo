error id: file://<WORKSPACE>/fpinscala/src/main/scala/Ch7.scala:[1062..1069) in Input.VirtualFile("file://<WORKSPACE>/fpinscala/src/main/scala/Ch7.scala", "package fpinscala

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

  object Par {
    
    // `unit` is represented as a function that returns a `UnitFuture`, which is a simple `
    // which is a simple implementation of `Future` that just wraps a constant value. 
    // It doesn't use the `ExecutorService` at all. It's always done and can't be cancelled. 
    // Its `get` method simply returns the value that we gave it.
    def unit[A](a: A): Par[A] = (es: ExecutorService) => UnitFuture(a) 

    def fork[A](a: => Par[A]): Par[A] =
      es => es.submit(
        new Callable[A] {
          def call = a(es).get
        })

    def lazyUnit[A](a: => A): Par[A] = fork(unit(a))

    def run[A](s: ExecutorService)(a: Par[A]): Future[A] = a(s)

    def 

    private case class UnitFuture[A](get: A) extends Future[A] {
      def isDone = true
      def get(timeout: Long, units: TimeUnit) = get
      def isCancelled = false
      def cancel(evenIfRunning: Boolean): Boolean = false
    }
  
  
  }
  
}

object Examples {
  import Ch7.Par

  def sum(ints: IndexedSeq[Int]): Int = 
    if (ints.size <= 1)
      ints.headOption.getOrElse(0)
    else {
      val (l,r) = ints.splitAt(ints.length / 2)
      val sumL: Par[Int] = Par.lazyUnit(sum(l))
      val sumR: Par[Int] = Par.lazyUnit(sum(r))
      Par.run(es).get(sumL) + Par.get(sumR)
    }
}")
file://<WORKSPACE>/file:<WORKSPACE>/fpinscala/src/main/scala/Ch7.scala
file://<WORKSPACE>/fpinscala/src/main/scala/Ch7.scala:37: error: expected identifier; obtained private
    private case class UnitFuture[A](get: A) extends Future[A] {
    ^
#### Short summary: 

expected identifier; obtained private