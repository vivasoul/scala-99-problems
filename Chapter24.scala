/*
sealed abstract class Tree extends Traversable[Int] {
  def foreach[U](f:Int => U) = this match {
    case  Node(elem) => f(elem)
    case  Branch(l,r) => l foreach f; r foreach f
  }
}
*/

sealed abstract class Tree extends Iterable[Int] {
  def iterator: Iterator[Int] = this match {
    case  Node(elem) => Iterator.single(elem)
    case  Branch(l,r) => l.iterator ++ r.iterator
  }
}

case class Branch(left:Tree, right:Tree) extends Tree
case class Node(elem: Int) extends Tree
