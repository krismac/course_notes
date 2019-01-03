# Homework

Create your own library class with an internal collection of books.

## MVP

- Books should have title, author and genre.
- Write a method to count the number of books in the library.
- Write a method to add a book to the library stock.
- Add a capacity to the library and write a method to check if stock is full before adding a book.

## Extensions:

- Add a third class which interacts with the other two. E.g. you could add a `Borrower` with a method that takes a `Book` and moves to the `Borrower`'s collection.

## Advanced Extension

- The library wants to keep track of it's number of books by genre. Using a [HashMap](hashmaps.md), store the genre of each book as the key - and a count of how many books of that genre as the value.
