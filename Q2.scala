case class Book(title: String, author: String, isbn: String)

var library: Set[Book] = Set(
  Book("Book 01", "Author 01", "9780981531649"),
  Book("Book 02", "Author 02", "9780132350884"),
  Book("Book 03", "Author 03", "9780201633610")
)

def addBook(book: Book): Unit = {
  library += book
  println(s"Added Book: ${book.title} by ${book.author}")
}

def removeBook(isbn: String): Unit = {
  val removedBook = library.find(_.isbn == isbn)
  removedBook match {
    case Some(book) => // Represents a container holding a value.
      library -= book
      println(s"Removed Book: ${book.title} by ${book.author}")
    case None =>
      println(s"Book with ISBN $isbn Not Found in the Library.")
  }
}

def containsBook(isbn: String): Boolean = {
  library.exists(_.isbn == isbn) // _ Represents each element of a collection
}

def displayLibrary(): Unit = {
  println("Books in the Library:")
  library.foreach(book =>
    println(s"${book.title} by ${book.author}, ISBN: ${book.isbn}")
  )
}

def searchByTitle(title: String): Unit = {
  library.find(_.title.toLowerCase == title.toLowerCase) match {
    case Some(book) =>
      println(
        s"Book found: ${book.title} by ${book.author}, ISBN: ${book.isbn}"
      )
    case None =>
      println(s"Book With Title '$title' Not Found in the Library.")
  }
}

def displayBooksByAuthor(author: String): Unit = {
  val booksByAuthor =
    library.filter(_.author.toLowerCase == author.toLowerCase)
  if (booksByAuthor.nonEmpty) {
    println(s"Books by $author:")
    booksByAuthor.foreach(book => println(s"${book.title}, ISBN: ${book.isbn}"))
  } else {
    println(s"No Books Found By Author '$author' in the Library.")
  }
}

@main
def main(): Unit = {

  displayLibrary()
  println()

  addBook(Book("Book 04", "Author 04", "9780201616224"))
  displayLibrary()
  println()

  removeBook("9780201633610")
  displayLibrary()
  println()

  searchByTitle("Book 02")
  println()

  displayBooksByAuthor("Author 01")
}
