/*
Duplicate the elements of a list.
Example:
scala> duplicate(List('a, 'b, 'c, 'c, 'd))
res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
*/
object P14 {
  def duplicate[A](xs:List[A]):List[A] = xs flatMap(x => List(x,x))
}

P14.duplicate(List('a, 'b, 'c, 'c, 'd))