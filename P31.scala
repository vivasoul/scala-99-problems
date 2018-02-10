/*
Determine whether a given integer number is prime.
scala> 7.isPrime
res0: Boolean = true
*/
object P31 {


  class PrimeInt (val n: Int){
    def isPrime(): Boolean = (n != 0) && {
      val m = Math.abs(this.n)
      val r = Math.round(Math.sqrt(m)).toInt

      val q = for (i <- 2 to r if (m % i) == 0) yield i

      q.isEmpty
    }
  }
}
import scala.language.implicitConversions
implicit def intToPrimeInt(n: Int) = new P31.PrimeInt(n)

7.isPrime