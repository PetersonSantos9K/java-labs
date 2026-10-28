package controller;

import api.request.ApiRequest;
import dto.request.AutorRequestDTO;
import dto.response.AutorResponseDTO;
import io.javalin.Javalin;
import api.response.ApiResponse;
import api.message.sucess.AutorSuccessMessage;
import service.AutorService;

import java.util.List;

public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService){
        this.autorService = autorService;
    }

    public void registerRoutes(Javalin app){

        app.get("/autores", ctx -> {
            ctx.status(200).json(new ApiResponse<List<AutorResponseDTO>>(
                    true,
                    AutorSuccessMessage.AUTORES_ENCONTRADOS_SUCESS.getMessage(),
                    autorService.listaDeAutores()
            ));
        });

        app.get("/autores/{id}", ctx -> {
            String id = ctx.pathParam("id");
            AutorResponseDTO autorResponseDTO = autorService.buscarAutorPorId(id);
            ctx.status(200).json(new ApiResponse<AutorResponseDTO>(
                    true,
                    AutorSuccessMessage.AUTOR_ENCONTRADO_POR_ID_SUCESS.getMessage(),
                    autorService.buscarAutorPorId(id)
            ));
        });


        app.get("/autores/buscar/{nome}", ctx -> {
            String nome = ctx.pathParam("nome");
            ctx.status(200).json(new ApiResponse<AutorResponseDTO>(
                    true,
                    AutorSuccessMessage.AUTOR_ENCONTRADO_POR_NOME_SUCESS.getMessage(),
                    autorService.buscarAutorPorNome(nome)
            ));
        });

        app.post("/autores", ctx -> {
            AutorRequestDTO autorRequestDTO = ctx.bodyAsClass(AutorRequestDTO.class);
            autorService.criarAutor(autorRequestDTO.getNome(), autorRequestDTO.getNacionalidade());
            ctx.status(201).json(new ApiRequest(
                    true,
                    AutorSuccessMessage.AUTOR_CADASTRADO_SUCESS.getMessage()
            ));
        });

        app.delete("/autores/{id}", ctx -> {
            String id = ctx.pathParam("id");
            autorService.excluirAutorPorId(id);
            ctx.status(204).json(new ApiRequest(
                    true,
                    AutorSuccessMessage.AUTOR_EXCLUIDO_SUCESS.getMessage()
            ));
        });

    }
}
