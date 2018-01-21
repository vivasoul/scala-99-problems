/*
Generate the combinations of K distinct objects chosen from the N elements of a list.
In how many ways can a committee of 3 be chosen from a group of 12 people?
We all know that there are C(12,3) = 220 possibilities (C(N,K) denotes the well-known binomial coefficient).
For pure mathematicians, this result may be great. But we want to really generate all the possibilities.
Example:

scala> combinations(3, List('a, 'b, 'c, 'd, 'e, 'f))
res0: List[List[Symbol]] = List(List('a, 'b, 'c), List('a, 'b, 'd), List('a, 'b, 'e), ...
*/
object P26 {
  def combinations[A](n: Int, xs: List[A]):List[List[A]] = {
    if(n == 0 || xs.isEmpty) List(Nil)
    else {
      for {
        (x, i) <- xs.take(xs.size-n+1).zipWithIndex
        ys <- combinations(n - 1, xs.drop(i + 1))
      } yield x :: ys
    }
  }
}

P26.combinations(3, List('a, 'b, 'c, 'd, 'e, 'f))
