@main
def main(): Unit = {
  fibonacci(10)
}

def fibonacci(n: Int): Unit = {
  for (i <- 0 until n) {
    print(s"${calculateFibonacci(i)} ")
  }
}

def calculateFibonacci(i: Int): Int = {
  if (i <= 1) i
  else calculateFibonacci(i - 1) + calculateFibonacci(i - 2)
}
