/*
Duplicate the elements of a list a given number of times.
Example:
scala> duplicateN(3, List('a, 'b, 'c, 'c, 'd))
res0: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
*/
object P15 {
  def duplicateN[A](n: Int, xs:List[A]):List[A] = xs flatMap(x => List.fill(n)(x))
}

P15.duplicateN(3, List('a, 'b, 'c, 'c, 'd))