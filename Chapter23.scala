case class Book(title: String, authors: String*)

val books: List[Book] =
  List (
    Book (
      "Structure and Interpretation of Coomputer Programs",
      "Abelson, Harold", "Sussman, Gerald J."
    ),
    Book (
      "Principles of Compiler Design",
      "Aho, Alfred", "Ullman, Jeffrey"
    ),
    Book (
      "Programming in Modula-2",
      "Wirth, Niklaus"
    ),
    Book (
      "Elements of ML Programming",
      "Ullman, Jeffrey"
    ),
    Book (
      "The Java Language Specification",
      "Gosling James","Joy, Bill", "Steele, Guy", "Bracha, Gilad"
    )
  )

for (b <- books; a <-b.authors if a startsWith "Gosling") yield b.title

for (b <- books if (b.title indexOf "Program") > -1 ) yield b.title

for (b1 <- books; b2 <- books if b1 != b2; a1 <- b1.authors; a2 <- b2.authors if a1 == a2) yield a1

def removeDuplicates[A](xs: List[A]): List[A] = {
  if(xs.isEmpty) xs
  else
    xs.head :: removeDuplicates(
      xs.tail filter (x => x != xs.head)
      //for( x <- xs.tail if x != xs.head) yield x
    )
}

/*
for (x <- expr1) yield expr2
expr1.map(x => expr2)

for (x <- expr1 if expr2) yield expr3
for (x <- expr1 withFilter ( x => expr2) ) yield expr3
expr1 withFilter( x => expr2) map ( x => expr3)

for(x <- expr1 if expr2; seq) yield expr3
for(x <- expr1 withFilter expr2; seq) yield expr3

for(x <- expr1; y <- expr2; seq) yield expr3
expr1.flatMap(x => for ( y <- expr2; seq) yield expr3)

 */

for (b1 <- books; b2 <- books if b1 != b2;
     a1 <- b1.authors; a2 <- b2.authors if a1 == a2) yield a1

books flatMap ( b1 => books withFilter ( b2 => b2 != b1 ) flatMap( b2 => b1.authors flatMap (a1 => b2.authors withFilter( a2 => a2 == a1) map(a2 => a1))))
books flatMap ( b1 => books withFilter ( _ != b1 ) flatMap( b2 => b1.authors flatMap (a1 => b2.authors withFilter( _ == a1) map ( _ => a1 ))))

/*
  for ( (x1, .... ,xn) <- expr1) yield expr2
  expr1.map {
    case (x1, ...., xn) => expr2
  }

  for(pat <- expr1) yield expr2
  expr1 withFilter {
    case pat => true
    case _ => false
  } map {
    case pat => expr2
  }
*/

/*
for (x <- expr1; y = expr2; seq) yield expr3
for((x,y) <- for(x <- expr1) yield (x, expr2); seq) yield expr3
for((x,y) <- expr1.map( x => (x, expr2) );seq) yield expr3

for( x <- expr1 ) body
expr1 foreach ( x => body )
for( x <- expr1; if expr2; y <- expr3) body
expr1 withFilter ( x => expr2 ) foreach ( x => expr3 foreach( y => body ))
*/

var sum = 0
val xss = List(List(1,2,3), List(4,5,6), List(7,8,9))
for (xs <- xss; x <- xs) sum += x

xss foreach ( _ foreach ( sum += _ ))

object Demo {
  def map[A,B](xs: List[A], f: A => B): List[B] =
    for(x <- xs) yield f(x)

  def flatMap[A,B](xs: List[A], f: A=> List[B]): List[B] =
    for(x <- xs; y <- f(x)) yield y

  def filter[A](xs: List[A], p: A => Boolean ): List[A] =
    for(x <- xs if p(x)) yield x
}

