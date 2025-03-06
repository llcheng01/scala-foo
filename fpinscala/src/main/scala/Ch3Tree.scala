package fpinscala

object Ch3Tree {
  
    sealed trait Tree[+A]
    case class Leaf[A](value: A) extends Tree[A]
    case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

    // 3.26
    def size[A](t: Tree[A]): Int = {
        // def loop(tt: Tree[A], acc: Int): Int = {
        //     tt match {
        //         case Leaf(_) => acc + 1
        //         case Branch(left, right) => loop(left, acc + 1) + loop(right, acc + 1)
        //     }
        // }
        // loop(t, 0)

        t match {
            case Leaf(_) => 1
            case Branch(left, right) => 1 + size(left) + size(right)
        }
    }

    // Breath First Search
    def BFS(t: Tree[A]): Tree[A] = {
        
    }
}
