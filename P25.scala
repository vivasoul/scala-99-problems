/*
Generate a random permutation of the elements of a list.
Hint: Use the solution of problem P23.
Example:

scala> randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
res0: List[Symbol] = List('b, 'a, 'd, 'c, 'e, 'f)
*/
object P25 {
  def randomSelect[A](n: Int, zs: List[A]): List[A] = {
    def removeAt[A](n: Int, xs: List[A], ys: List[A]): (List[A], List[A]) =
      if (n == 0) (xs, ys)
      else {
        val m: Int = ((xs.size - 1) * Math.random()).toInt
        removeAt(n - 1, xs.zipWithIndex.filterNot(_._2 == m).map(_._1), xs(m) :: ys)
      }

    removeAt(n, zs, Nil)._2
  }

  def randomPermute[A](xs: List[A]): List[A] = {
    randomSelect(xs.size, xs)
  }
}

P25.randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))