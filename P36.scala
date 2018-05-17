object P36 {
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

class P36(val m: Int) {
  import P36._
  def primeFactorsMultiplicity():List[(Int, Int)] = {
    recurPrimeFactorMultiplicity(m)
  }
}

import scala.language.implicitConversions
implicit def int2P36(n: Int) = new P36(n)
