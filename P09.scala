/*
Pack consecutive duplicates of list elements into sublists.
If a list contains repeated elements they should be placed in separate sublists.
Example:

scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
 */
object P09 {
  def pack[A](xs:List[A]):List[List[A]] = {
    def packR[B](ys:List[B]):List[List[B]] = ys match {
      case h :: t => ys.takeWhile(_ == h) :: packR(ys.dropWhile(_ == h))
      case Nil => Nil
    }
    packR(xs)
  }

  def pack2[A](xs:List[A]):List[List[A]] = {
    def packR2[B](ys_tp:(List[B],List[B])):List[List[B]] = ys_tp._2 match {
      case h :: t => ys_tp._1 :: packR2(ys_tp._2.span(_ == h ))
      case Nil => List(ys_tp._1)
    }
    packR2(xs.span(_ == xs.head))
  }
}
P09.pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
P09.pack2(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
