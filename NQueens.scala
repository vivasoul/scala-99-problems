object NQueens extends App {
  def inCheck(q1: (Int, Int), q2: (Int, Int)) =
    q1._1 == q2._1 ||
    q1._2 == q2._2 ||
    (q1._1 - q2._1).abs == (q1._2 - q2._2).abs

  def isSafe(queen: (Int, Int), queens: List[(Int, Int)]) =
    queens forall(q => ! inCheck(queen, q))

  def queens(n: Int): List[List[(Int, Int)]] = {
    def placeQueens(k: Int): List[List[(Int, Int)]] = {
      println(k)
      var a:List[List[(Int, Int)]] = Nil;
      if (k == 0)
        a = List(List())
      else
        a = for {
          queens <- placeQueens(k - 1)
          column <- 1 to n
          queen = (k, column)
          if isSafe(queen, queens)
        } yield queen :: queens
      println(a)
      a
    }
    placeQueens(n)
  }
}

import NQueens._