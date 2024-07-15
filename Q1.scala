import scala.io.StdIn.readLine

@main
def main(): Unit = {
  val productList = getProductList()
  printProductList(productList)
  println(s"Product Count : ${getTotalProducts(productList)}")
}

def getProductList(): List[String] = {
  var products: List[String] = List()
  var product: String = ""

  println("Enter the Names of the Products (Type 'done' to End):")

  product = readLine() // For the 1st Product
  while (product != "done") {
    if (product.nonEmpty) {
      products = products :+ product
    }
    product = readLine()
  }

  products
}

def printProductList(products: List[String]): Unit = {
  products.foreach { item =>
    println(s"${products.indexOf(item) + 1}. $item")
  }
}

def getTotalProducts(products: List[String]): Int = {
  products.length
}
