package WebServiceAPI.controllers;


import WebServiceAPI.models.Book;
import WebServiceAPI.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookRepository bookRepository;

	@GetMapping
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	// CREATE - Lägg till en ny bok
	@PostMapping
	public Book addBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}

	// READ - Hämta med hjälp av id
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable Long id) {
		return bookRepository.findById(id).orElse(null);
	}

	// READ - Hämta med hjälp av title
	@GetMapping("/title/{title}")
	public List<Book> findByTitle(@PathVariable String title) {
		return bookRepository.findByTitle(title);
	}

	// READ - Hämta med hjälp author
	@GetMapping("/author/{author}")
	public List<Book> findByAuthor(@PathVariable String author) {
		return bookRepository.findByAuthor(author);
	}

	// PUT - Uppdatera en befintlig bok med hjälp av id
	@PutMapping("/{id}")
	public ResponseEntity<?> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
		return bookRepository.findById(id).map(existingBook -> {
			// Endast uppdatera fält om de inte är null
			if (bookDetails.getTitle() != null) existingBook.setTitle(bookDetails.getTitle());
			if (bookDetails.getAuthor() != null) existingBook.setAuthor(bookDetails.getAuthor());

			// Uppdatera andra fält vid behov och kontrollera null-värden

			Book updatedBook = bookRepository.save(existingBook);
			return ResponseEntity.ok(updatedBook);
		}).orElseThrow(() -> new RuntimeException("Bok med ID " + id + " hittades inte"));
	}

	// Delete - Ta bort en bok med id
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable Long id) {
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Bok med ID " + id + " hittades inte"));

		bookRepository.delete(book);
		return ResponseEntity.ok().build();
	}
}
