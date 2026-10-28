package Book;


import Author.AuthorModel;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "book")
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(length = 100, unique = true, nullable = false)
    private String title;

    @Column(name = "publication_year", nullable = false)
    private Integer publicationYear;

    @ManyToOne
    @JoinColumn(name="author_id", referencedColumnName = "id")
    private AuthorModel author;

    public BookModel(String title, Integer publicationYear , AuthorModel author) {
        this.title = title;
        this.publicationYear = publicationYear;
        this.author = author;
    }

    public BookModel(){}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTittle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public AuthorModel getAuthor() {
        return author;
    }

}
