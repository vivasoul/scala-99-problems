/*
Run-length encoding of a list (direct solution).
Implement the so-called run-length encoding data compression method directly. I.e. don't use other methods you've written (like P09's pack); do all the work directly.
Example:

scala> encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
*/
object P13 {
  def encodeDirect[A](xs: List[A]):List[(Int, A)] = {
    if(xs.isEmpty)
      List()
    else{
      (List((1, xs.head)) /: xs.tail ){
        (x,y) =>
          if(x.last._2 == y){
            x match {
              case h :: Nil => List((h._1+1, y))
              case h :: t => x.init ::: List((x.last._1 +1,y))
            }
          }else{
            x ::: List((1,y))
          }
      }
    }
  }
  def encodeDirect2[A](xs: List[A]):List[(Int, A)] = {
    if(xs.isEmpty)
      List()
    else
      ( xs.init :\ List((1, xs.last)) ){
        (x,y) =>
          if(y.head._2 == x) (y.head._1 + 1, x) :: y.tail
          else 			         (1,x) :: y
      }
  }
}

P13.encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
P13.encodeDirect2(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))