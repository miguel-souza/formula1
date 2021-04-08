package yasmin.formula1.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import yasmin.formula1.controller.exception.ErroInternoException;
import yasmin.formula1.controller.exception.NotFoundException;
import yasmin.formula1.model.Data;
import yasmin.formula1.model.dto.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class EquipeService {

    ObjectMapper objectMapper = new ObjectMapper();
    private static final String EQUIPE_URI = "http://ergast.com/api/f1/";

    public EquipesDTO obter() throws IOException, InterruptedException {
        Data data = objectMapper.readValue(obterArquivo(EQUIPE_URI + "constructors.json"), Data.class);
        return new EquipesDTO(data.getMrData());
    }

    public EquipeDTO obterPorId(String id) throws IOException, InterruptedException {
        String path = "constructors/" +  id + ".json";
        Data data = objectMapper.readValue(obterArquivo(EQUIPE_URI + path), Data.class);

        if(data.getMrData().getEquipes().getEquipes().isEmpty())
            throw new NotFoundException("Não foi encontrada nenhuma equipe para o id informado: " + id);

        return new EquipeDTO(data.getMrData().getEquipes().getEquipes().stream().findFirst().get());
    }

    public String obterArquivo(String uri) throws IOException, InterruptedException {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(uri))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() != 200)
                throw new ErroInternoException("Ocorreu um erro interno no servidor.");

        return response.body();
    }
}
