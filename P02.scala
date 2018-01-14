/*
Find the last but one element of a list.
Example:
scala> penultimate(List(1, 1, 2, 3, 5, 8))
res0: Int = 5
*/
object P02 {
  def penultimate[A](xs:List[A]):A = xs.init.last
}

P02.penultimate(List(1, 1, 2, 3, 5, 8))
