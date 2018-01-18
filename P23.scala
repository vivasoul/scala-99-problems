/*
Extract a given number of randomly selected elements from a list.
Example:
scala> randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
res0: List[Symbol] = List('e, 'd, 'a)
*/
object P23 {
  def randomSelect[A](n: Int, zs: List[A]): List[A] = {
    def removeAt[A](n: Int, xs: List[A], ys: List[A]): (List[A], List[A]) =
      if (n == 0) (xs, ys)
      else {
        val m: Int = ((xs.size - 1) * Math.random()).toInt
        removeAt(n - 1, xs.zipWithIndex.filterNot(_._2 == m).map(_._1), xs(m) :: ys)
      }

    removeAt(n, zs, Nil)._2
  }
}

P23.randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))