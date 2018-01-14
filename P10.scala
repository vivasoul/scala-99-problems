/*
Run-length encoding of a list.
Use the result of problem P09 to implement the so-called run-length encoding data compression method. Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates of the element E.
Example:

scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
*/
object P10 {
  def encode[A](xs: List[A]): List[(Int, A)] = {
    def packR[B](ys: List[B]):List[List[B]] = ys match {
      case h :: t => ys.takeWhile(_ == h) :: packR(ys.dropWhile(_ == h))
      case Nil => Nil
    }
    val zs = packR(xs)
    for(z <- zs if(z != Nil)) yield (z.size, z.head)
  }
}

P10.encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))