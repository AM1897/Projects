package Aram.WebServiceBooks.book.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity // Annotering för att markera att klassen är en entitet.
@Table(name = "books")  // Annotering för att koppla klassen till en tabell i databasen.
@Data                // Annotering för att Lombok ska generera getters och setters.
public class Book { // Klass för att representera en bok.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Annotering för att indikera att id-värdet ska genereras automatiskt.
    private Long id;

    @Column(nullable = false)   // Annotering för att indikera att kolumnen inte får vara null.
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false, unique = true)
    private String isbn;

    @Column(name = "published_year")
    private Integer publishedYear;

    // Getters och setters genereras av Lombok (@Data).
}
