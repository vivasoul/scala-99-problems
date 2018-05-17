/*
Calculate Euler's totient function phi(m) (improved).
See problem P34 for the definition of Euler's totient function.
If the list of the prime factors of a number m is known in the form of problem P36 then the function phi(m>) can be efficiently calculated as follows:
 Let [[p1, m1], [p2, m2], [p3, m3], ...] be the list of prime factors (and their multiplicities) of a given number m. Then phi(m) can be calculated with the following formula:
phi(m) = (p1-1)*p1(m1-1) * (p2-1)*p2(m2-1) * (p3-1)*p3(m3-1) * ...

Note that ab stands for the bth power of a.
*/

object P37 {
  def recurPrimeFactorMultiplicity(q: Int): List[(Int, Int)] = {
    (2 to q).toStream.dropWhile(x => (q % x) > 0) match {
      case Stream() => Nil
      case e => {
        val xs = recurPrimeFactorMultiplicity(q / e.head)
        if( xs != Nil)
        {
          if(xs.head._1 == e.head) (xs.head._1, xs.head._2 + 1) :: xs.tail
          else					  		 (e.head, 1) :: xs
        }
        else (e.head, 1) :: xs
      }
    }
  }
}

class P37(val m: Int) {
  import P37._
  def totientImproved(): Int = {
    ( 1 /: recurPrimeFactorMultiplicity(m))( (acc, e) => acc * (e._1-1) * Math.pow(e._1, e._2 -1).toInt  )
  }
}

import scala.language.implicitConversions
implicit def int2P37(n: Int) = new P37(n)
