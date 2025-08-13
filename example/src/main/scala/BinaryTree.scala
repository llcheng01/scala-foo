package example

sealed trait BinaryTree[T] {
  def isBalanced: Boolean
  def height: Int
}

object BinaryTree {
  case class Node[T](
      value: T,
      left: BinaryTree[T] = BinaryTree.Empty[T](),
      right: BinaryTree[T] = BinaryTree.Empty[T]()
  ) extends BinaryTree[T] {
    override def isBalanced: Boolean =
      Math.abs(
        left.height - right.height
      ) <= 1 && left.isBalanced && right.isBalanced

    private def heightIterative: Int = {
      val res: Iterator[List[BinaryTree[T]]] =
        Iterator.iterate[List[BinaryTree[T]]](left :: right :: Nil) {
          levelItems =>
            levelItems
              .collect({
                case Node(_, left, right) =>
                  left :: right :: Nil
              })
              .flatten
        }

      res.takeWhile(_.nonEmpty).size
    }

    override def height: Int = heightIterative

  }

  case class Empty[T]() extends BinaryTree[T] {
    override def isBalanced: Boolean = true
    override def height: Int = 0
  }

}
