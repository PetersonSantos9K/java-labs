package Author;

import Book.LivroResponseDTO;
import api.message.sucess.AutorSuccessMessage;
import api.response.ApiResponse;
import io.javalin.config.JavalinConfig;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class AuthorController {

    private final AuthorService service;

    public AuthorController(AuthorService service){
        this.service = service;
    }

    public void registerRoutes(JavalinConfig config){

        config.routes.post("/author", this::createdAuthor);
        config.routes.get("/author/{id}", this::getAuthorById);
        //config.routes.get("/author", this::getAuthorByName);
        config.routes.get("/authors", this::getAuthors);
        config.routes.delete("/author/{id}", this::deleteAuthor);
    }

    private void createdAuthor(@NotNull Context ctx){

        AuthorRequestDTO dto = ctx.bodyAsClass(AuthorRequestDTO.class);

        ctx.status(201).json(new ApiResponse<>(
                true,
                AutorSuccessMessage.RESOURCE_CREATED.getMessage(),
                service.createAuthor(dto.getNome(), dto.getNacionalidade())
        ));
    }
    private void getAuthorById(@NotNull Context ctx){
        UUID uuid = UUID.fromString(ctx.pathParam("id"));
        ctx.status(200).json(new ApiResponse<>(
                true,
                AutorSuccessMessage.RESOURCE_FOUND.getMessage(),
                service.findById(uuid)
        ));
    }
    private void getAuthorByName(@NotNull Context ctx){

        String name = ctx.queryParamAsClass("name", String.class).getOrDefault("");
        ctx.status(200).json(new ApiResponse<>(
                true,
                AutorSuccessMessage.RESOURCE_FOUND.getMessage(),
                service.findByName(name)
        ));

    }
    private void getAuthors(@NotNull Context ctx){
        int page = Integer.parseInt(
                String.valueOf(ctx.queryParamAsClass("page", Integer.class)
                        .getOrDefault(1)
                )
        );
        int limit = Integer.parseInt(
                String.valueOf(ctx.queryParamAsClass("limit", Integer.class)
                        .getOrDefault(1)
                )
        );
        ctx.status(200).json(new ApiResponse<>(
                true,
                AutorSuccessMessage.RESOURCE_FOUND.getMessage(),
                service.getAll(page, limit)
        ));
    }
    private void deleteAuthor(@NotNull Context ctx){
        UUID uuid = UUID.fromString(ctx.pathParam("id"));
        service.delete(uuid);
        ctx.status(202);
    }

}
