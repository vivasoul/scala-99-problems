/*
Insert an element at a given position into a list.
Example:
scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)
*/
object P21 {
  def insertAt[A](x: A, n: Int, xs: List[A]):List[A] = {
    val (prev, next) = xs.splitAt(n)
    prev ::: (x :: next)
  }
}

P21.insertAt('new, 1, List('a, 'b, 'c, 'd))