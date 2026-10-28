import Author.AuthorDAOImpl;
import Author.AuthorResponseDTO;
import Author.AuthorService;

public class Program {

    public static void main(String[] args) {

        var authorService = new AuthorService(new AuthorDAOImpl());
        AuthorResponseDTO a = authorService.createAuthor("test1", "Brasil");
        System.out.println(a.getId());

    }
}
