import controller.AutorController;
import controller.LivroController;
import database.ConnectionFactory;
import exception.AppException;
import repository.postgreSQL.AutorDAOImpl;
import repository.postgreSQL.LivroDAOImpl;
import api.ErrorResponse;
import io.javalin.Javalin;
import io.javalin.plugin.bundled.CorsPluginConfig;
import service.AutorService;
import service.LivroService;

public class App {

    public static void main(String[] args) {

            var autorDAO = new AutorDAOImpl();
            var autorService = new AutorService(autorDAO);
            var autorController = new AutorController(autorService);

            var livroDAO = new LivroDAOImpl();
            var livroService = new LivroService(autorService, livroDAO);
            var livroController = new LivroController(livroService);

            Javalin app = Javalin.create( config -> {
                config.bundledPlugins.enableCors(cors -> cors.addRule(CorsPluginConfig.CorsRule::anyHost));
            });

            app.events(eventConfig -> {
                eventConfig.serverStopping(ConnectionFactory::closePool);
            });

            autorController.registerRoutes(app);
            livroController.registerRotas(app);
            appException(app);

            app.start(8080);
    }

    private static void appException(Javalin app) {

        app.exception(AppException.class, (e, ctx) -> {
           ctx.status(e.getStatus()).json(new ErrorResponse(e.getStatus(), e.getMessage()));
        });

        app.exception(Exception.class, (e, ctx) -> {
            ctx.status(500).json(new ErrorResponse(500, "Erro inesperado no servidor"));
        });
    }

}
