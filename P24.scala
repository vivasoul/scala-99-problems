/*
Lotto: Draw N different random numbers from the set 1..M.
Example:
scala> lotto(6, 49)
res0: List[Int] = List(23, 1, 17, 33, 21, 37)
*/
object P24 {
  def lotto(n: Int, lim: Int):List[Int] = {
    if (n == 0) Nil
    else{
      val m = (Math.random()*(lim-1)).toInt + 1
      m :: lotto(n-1, lim)
    }
  }
}

P24.lotto(6, 49)