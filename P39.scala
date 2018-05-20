/*
A list of prime numbers.
  Given a range of integers by its lower and upper limit, construct a list of all prime numbers in that range.
scala> listPrimesinRange(7 to 31)
res0: List[Int] = List(7, 11, 13, 17, 19, 23, 29, 31)
*/

object P39 {
  //From P31.scala
  def isPrime(n: Int): Boolean = (n != 0) && {
    val m = Math.abs(n)
    val r = Math.round(Math.sqrt(m)).toInt

    val q = for (i <- 2 to r if (m % i) == 0) yield i

    q.isEmpty
  }

  def listPrimesinRange(xs: Range): List[Int] ={
    xs.filter(isPrime(_)).toList
  }
}