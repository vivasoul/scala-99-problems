/*
Reverse a list.
Example:
scala> reverse(List(1, 1, 2, 3, 5, 8))
res0: List[Int] = List(8, 5, 3, 2, 1, 1)
*/
object P05 {
  def reverse[A](xs: List[A]):List[A] = xs.reverse
}

P05.reverse(List(1, 1, 2, 3, 5, 8))