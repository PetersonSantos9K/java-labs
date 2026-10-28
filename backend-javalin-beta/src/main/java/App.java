import Author.AuthorController;
import Author.AuthorDAOImpl;
import Author.AuthorService;
import io.javalin.Javalin;

public class App {

    public static void main(String[] args) {

        var authorService = new AuthorService(new AuthorDAOImpl());
        var authorController = new AuthorController(authorService);

        Javalin.create(config -> {
            authorController.registerRoutes(config);

        }).start(8080);



    }


    private static void appException(Javalin app) {


    }

}
