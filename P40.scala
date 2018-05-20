/*
Goldbach's conjecture.
Goldbach's conjecture says that every positive even number greater than 2 is the sum of two prime numbers.
E.g. 28 = 5 + 23. It is one of the most famous facts in number theory that has not been proved to be correct in the general case.
It has been numerically confirmed up to very large numbers (much larger than Scala's Int can represent).
Write a function to find the two prime numbers that sum up to a given even integer.
scala> 28.goldbach
res0: (Int, Int) = (5,23)
*/

class P40(val n: Int){
  //From P31.scala
  private def isPrime(k: Int): Boolean = (k != 0) && {
    val m = Math.abs(k)
    val r = Math.round(Math.sqrt(m)).toInt

    val q = for (i <- 2 to r if (m % i) == 0) yield i

    q.isEmpty
  }

  def goldbach():(Int, Int)  = {
    assert( this.n > 2, "It should be grater than 2.")
    assert( (this.n % 2) == 0, "It should be an even number.")

    val xs = Stream.cons(2, Stream.range(3, n, 2)).dropWhile(x => !isPrime(x) || !isPrime(this.n-x))

    if(xs.isEmpty) (0,this.n)
    else           (xs.head, this.n - xs.head)
  }
}

import scala.language.implicitConversions
implicit def int2P40(m: Int) = new P40(m)

//P41 solution
def printGoldBachList(xs:Range): Unit = {
  xs.withFilter( _ % 2  == 0).foreach( x => println(x.goldbach))
}