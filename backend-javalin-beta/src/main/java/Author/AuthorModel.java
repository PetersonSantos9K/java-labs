package Author;


import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "author")
public class AuthorModel implements Comparable<AuthorModel>{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String nationality;

    public AuthorModel(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }

    public AuthorModel(){}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AuthorModel that = (AuthorModel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean empty(){

        if(id == null || name == null || nationality == null){
            return true;
        }
        return name.isEmpty() || nationality.isEmpty();
    }

    @Override
    public int compareTo(@NotNull AuthorModel o) {
        if(name.compareTo(o.name) != 0){
            return name.compareTo(o.name);
        }
        return nationality.compareTo(o.nationality);
    }
}
