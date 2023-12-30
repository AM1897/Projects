package Aram.WebServiceBooks.book.controller;

import Aram.WebServiceBooks.book.model.Book;
import Aram.WebServiceBooks.book.service.BookService; // Detta borde vara din tjänst, inte ditt repo direkt.
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController { // Detta borde vara din tjänst, inte ditt repo direkt.

    private final BookService bookService; // Detta borde vara din tjänst, inte ditt repo direkt.

    @Autowired // Detta borde vara din tjänst, inte ditt repo direkt.
    public BookController(BookService bookService) { // Detta borde vara din tjänst, inte ditt repo direkt.
        this.bookService = bookService; // Detta borde vara din tjänst, inte ditt repo direkt.
    } // Detta borde vara din tjänst, inte ditt repo direkt.

    @PostMapping // Detta borde vara din tjänst, inte ditt repo direkt.
    public ResponseEntity<Book> addBook(@RequestBody Book book) { // Detta borde vara din tjänst, inte ditt repo direkt.
        Book savedBook = bookService.addBook(book); // Detta borde vara din tjänst, inte ditt repo direkt.
        return ResponseEntity.ok(savedBook); // Detta borde vara din tjänst, inte ditt repo direkt.
    }

    @GetMapping // Detta borde vara din tjänst, inte ditt repo direkt.
    public ResponseEntity<List<Book>> findAllBooks() { // Detta borde vara din tjänst, inte ditt repo direkt.
        List<Book> books = bookService.findAllBooks(); // Detta borde vara din tjänst, inte ditt repo direkt.
        return ResponseEntity.ok(books); // Detta borde vara din tjänst, inte ditt repo direkt.
    }

    @GetMapping("/{id}")    // Detta borde vara din tjänst, inte ditt repo direkt.
    public ResponseEntity<Book> findBookById(@PathVariable Long id) {   // Detta borde vara din tjänst, inte ditt repo direkt.
        Book book = bookService.findBookById(id);                 // Detta borde vara din tjänst, inte ditt repo direkt.
        return book != null ? ResponseEntity.ok(book) : ResponseEntity.notFound().build();  // Detta borde vara din tjänst, inte ditt repo direkt.
    }

    @PutMapping("/{id}")    // Detta borde vara din tjänst, inte ditt repo direkt.
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) { // Detta borde vara din tjänst, inte ditt repo direkt.
        Book updatedBook = bookService.updateBook(id, book);    // Detta borde vara din tjänst, inte ditt repo direkt.
        return updatedBook != null ? ResponseEntity.ok(updatedBook) : ResponseEntity.notFound().build();    // Detta borde vara din tjänst, inte ditt repo direkt.
    }

    @DeleteMapping("/{id}") // Detta borde vara din tjänst, inte ditt repo direkt.
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) { // Detta borde vara din tjänst, inte ditt repo direkt.
        boolean isRemoved = bookService.deleteBook(id); // Detta borde vara din tjänst, inte ditt repo direkt.
        return isRemoved ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();  // Detta borde vara din tjänst, inte ditt repo direkt.
    }
}
