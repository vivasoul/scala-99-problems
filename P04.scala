/*
Find the number of elements of a list.
Example:
scala> length(List(1, 1, 2, 3, 5, 8))
res0: Int = 6
*/
object P04 {
  def length[A](xs: List[A]): Int = xs.size
}

P04.length(List(1, 1, 2, 3, 5, 8))