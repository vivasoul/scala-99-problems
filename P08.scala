/*
Eliminate consecutive duplicates of list elements.
If a list contains repeated elements they should be replaced with a single copy of the element. The order of the elements should not be changed.
Example:
scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)
*/
object P08 extends App {
  def compress[A](xs: List[A]):List[A] = xs match {
      case hd :: tl => {
        val ys = hd :: xs.init

        val t = for {
          (x,y) <- xs zip ys
          if(x != y)
        } yield x

        hd :: t
      }
      case _ => List()
    }
}

P08.compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))

