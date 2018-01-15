/*
Modified run-length encoding.
Modify the result of problem P10 in such a way that if an element has no duplicates it is simply copied into the result list. Only elements with duplicates are transferred as (N, E) terms.
Example:

scala> encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
 */
object P11 {
  def encodeModified[A](xs: List[A]): List[Any] = {
    def packR[B](ys: List[B]):List[List[B]] = ys match {
      case h :: t => ys.takeWhile(_ == h) :: packR(ys.dropWhile(_ == h))
      case Nil => Nil
    }
    for(x <- packR(xs) if(x != Nil)) yield (x.size, x.head) match {
      case (1, b) => b
      case (a:Int, b) => (a,b)
    }
  }
}

P11.encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))