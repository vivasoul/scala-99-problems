/*
Drop every Nth element from a list.
Example:
scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
*/
object P16 {
  def drop[A](n: Int, xs: List[A]):List[A] = {
    for{ (x,i) <- xs.zipWithIndex; if ( (i+1) % n) != 0 } yield x
  }
}

P16.drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))