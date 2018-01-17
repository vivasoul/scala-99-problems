/*
Remove the Kth element from a list.
Return the list and the removed element in a Tuple. Elements are numbered from 0.
Example:

scala> removeAt(1, List('a, 'b, 'c, 'd))
res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)
*/
object P20 {
  def removeAt[A](n: Int, xs: List[A]):(List[A],A) = (xs.zipWithIndex.filterNot(_._2  == n).map(_._1), xs(n))
}

P20.removeAt(1, List('a, 'b, 'c, 'd))