/*
Calculate Euler's totient function phi(m).
Euler's so-called totient function phi(m) is defined as the number of positive integers r (1 <= r <= m) that are coprime to m.
scala> 10.totient
res0: Int = 4
*/
class P34(val m:Int) {
  //From P32
  def gcd(a: Int, b: Int): Int = {
    if(b == 0)  a
    else        gcd (b, a % b)
  }

  def totient():Int = {
    if(m > 0) (1 to m).filter(x => gcd(m,x) == 1).size
    else      0
  }
}

import scala.language.implicitConversions
implicit def int2P34(n: Int) = new P34(n)
