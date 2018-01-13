/*
Flatten a nested list structure.
Example:
scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
res0: List[Any] = List(1, 1, 2, 3, 5, 8)
*/
object P07 {

  def flatten(xs: List[Any]) : List[Any] = {
    var ys:List[Any] = Nil
    for( x <- xs ) x match {
      case x : List[Any] => ys = flatten(x) ::: ys
      case x: Any => ys = x :: ys
      case _ => Nil
    }
    ys
  }

  def flatten2(xs: Any) : List[Any] = xs match {
    case hd :: tl =>  flatten2(hd) ::: flatten2(tl)
    case x: List[Any] => x
    case x: Any => List(x)
    //case _ => Nil
  }

  def flatten3(xs: List[Any]) : List[Any] = xs flatMap ( _ match {
    case xs : List[_] =>  flatten3(xs)
    case e => List(e)
  } )
}

val a = P07.flatten(List(List(1, 1), 2, List(3, List(5, 8))))
println(a)

val b = P07.flatten2(List(List(1, 1), 2, List(3, List(5, 8))))
println(b)

val c = P07.flatten3(List(List(1, 1), 2, List(3, List(5, 8))))
println(c)
