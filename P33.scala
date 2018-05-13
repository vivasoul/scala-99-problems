/*
Determine whether two positive integer numbers are coprime.
Two numbers are coprime if their greatest common divisor equals 1.
scala> 35.isCoprimeTo(64)
res0: Boolean = true
*/
class P33(val m: Int){
  //From P32
  def gcd(a: Int, b: Int): Int = {
    if(b == 0)  a
    else        gcd (b, a % b)
  }

  def isCoprimeTo(n :Int) :Boolean = {
    gcd(m, n) == 1
  }
}

import scala.language.implicitConversions
implicit def int2P33(n: Int) = new P33(n)