import scala.collection.mutable

val inputs = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

val inputs2 = (1 to 10).toList

// Add all the numbers together
inputs.reduce((a, b) => a + b)

def isEven(x: Int): Boolean = x % 2 == 0

def isDivisibleBy(what: Int)(x: Int) =
  x % what == 0

def isDivisibleBy3(x: Int) = x % 3 == 0

println(isDivisibleBy(5)(10))

inputs
  .filter { i =>
    i % 2 == 0
  }

inputs
  .filter(isDivisibleBy(3))

inputs
  .filter(isEven)
  .map(number => number * number)


for (i <- inputs if i % 2 == 0) yield {
  i * i
}
// Will be compiled to:
inputs
  .filter(i => i % 2 == 0)
  .map(i => i * i)

//---------------------

for (i <- inputs if i % 2 == 0) {
  println(s"Hello $i")
}
// Will be compiled to:
inputs
  .filter(i => i % 2 == 0)
  .foreach(i => println(s"Hello $i"))

//--------------------

val squared = for (i <- inputs) yield {
  // any number of statements
  i * i
}

for {
  i <- inputs if i % 3 == 0
  j <- inputs2 if i != j
} yield (i, j)

inputs
  .collect {
    case i if i % 2 == 0 => s"$i is Even"
  }


val option = Option(null)

for (o <- option) {
  println(s"Option is $o")
}

// Flattening list of lists
val listOfLists = List(List(1, 2), List(3, 4, 5))

listOfLists.flatten

List(1, 2, 3, 4).flatMap(i => List(i, i * 2, i * 3))



