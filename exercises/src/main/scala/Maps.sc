
val myMap = Map("Johan" -> 12,
  "Kalle" -> 15,
  "Olle" -> 23)

val thisWillBeAMap =
  for ( (k, v) <- myMap if v > 12) yield {
  (k, s"$k is $v")
}

val thisWillBeAList =
  for ( (k, v) <- myMap if v > 12) yield {
    s"$k is $v"
  }

myMap
  .filter( kv => kv._2 > 12 )
  .map( kv => (kv._1, s"${kv._1} is ${kv._2}"))

myMap
  .collect {
    case (k, v) if v > 12 => (k, s"$k is $v")
  }

// Concatenate maps:
myMap ++ Map("Johan" -> 99)

