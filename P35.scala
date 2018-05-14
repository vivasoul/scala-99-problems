/*
Determine the prime factors of a given positive integer.
  Construct a flat list containing the prime factors in ascending order.
  scala> 315.primeFactors
res0: List[Int] = List(3, 3, 5, 7)
*/
object P35 {
  def recurPrimeFactor(q: Int): List[Int] = {
    (2 to q).toStream.dropWhile(x => (q % x) > 0) match {
      case Stream() => Nil
      case e => e.head :: recurPrimeFactor(q / e.head)
    }
  }
}

class P35(val m: Int) {
  import P35._
  def primeFactors():List[Int] = {
    recurPrimeFactor(m)
  }
}

import scala.language.implicitConversions
implicit def int2P35(n: Int) = new P35(n)

