package controller;
import io.javalin.Javalin;
import model.LivroModel;
import service.LivroService;

import java.util.Map;

public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    public void registerRotas(Javalin app) {

        app.get("/livros", ctx -> ctx.json(livroService.listaDeLivros()));

        app.get("/livros/{id}", ctx -> {
            String id = ctx.pathParam("id");
            ctx.json(livroService.buscarLivroPorId(id));
        });

        app.get("/livros/buscar/{titulo}", ctx -> {
            String titulo = ctx.pathParam("titulo");
            ctx.json(livroService.buscarLivroPorTitulo(titulo));
        });

        app.get("/livros/autor/{autor}", ctx -> {
            String autor = ctx.pathParam("autor");
            ctx.json(livroService.listaDeLivrosPorAutor(autor));
        });

        app.post("/livros", ctx -> {
            LivroModel livro = ctx.bodyAsClass(LivroModel.class);
            livroService.criarLivro(livro.getTitulo(), livro.getAnoPublicacao(), livro.getAutorId());
            ctx.status(201).json(Map.of(
                    "message", "Livro criado com sucesso"
            ));

        });

        app.delete("/livros/{id}", ctx -> {
            String id = ctx.pathParam("id");
            livroService.excluirLivroPorId(id);
            ctx.status(204);
        });
    }
}
