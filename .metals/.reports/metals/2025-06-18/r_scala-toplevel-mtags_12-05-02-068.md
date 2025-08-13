error id: file://<WORKSPACE>/fpinscala/src/main/scala/Ch7.scala:[276..277) in Input.VirtualFile("file://<WORKSPACE>/fpinscala/src/main/scala/Ch7.scala", "package fpinscala

object Ch7 {

  trait Par[+A] {
    def map[B](f: A => B): Par[B] = this match {
        case MapPar(par, g) => MapPar(par, g andThen f)
        case _ => MapPar(this, f)
    }
  }

  case class MapPar[A, +B](par: Par[A], f: A => B) extends Par[B]


  def 
}")
file://<WORKSPACE>/file:<WORKSPACE>/fpinscala/src/main/scala/Ch7.scala
file://<WORKSPACE>/fpinscala/src/main/scala/Ch7.scala:16: error: expected identifier; obtained rbrace
}
^
#### Short summary: 

expected identifier; obtained rbrace