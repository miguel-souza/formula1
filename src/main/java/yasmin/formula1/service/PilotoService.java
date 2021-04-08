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
import java.util.Optional;

@Service
public class PilotoService {

    ObjectMapper objectMapper = new ObjectMapper();
    private static final String PILOTO_URI = "http://ergast.com/api/f1/";

    public PilotosDTO obter() throws IOException, InterruptedException {
        Data data = objectMapper.readValue(obterArquivo(PILOTO_URI + "drivers.json"), Data.class);
        return new PilotosDTO(data.getMrData());
    }

    public PilotoDTO obterPorId(String id) throws IOException, InterruptedException {
        String path = "drivers/" +  id + ".json";
        Data data = objectMapper.readValue(obterArquivo(PILOTO_URI + path), Data.class);
        if(data.getMrData().getPilotos().getPilotos().isEmpty())
            throw new NotFoundException("Não foi encontrado nenhum piloto para o id informado: " + id);

        return new PilotoDTO(data.getMrData().getPilotos().getPilotos().stream().findFirst().get());
    }

    public String obterArquivo(String uri) throws IOException, InterruptedException {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(uri))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if(response.body().isEmpty())
                throw new ErroInternoException("Ocorreu um erro interno no servidor.");

        return response.body();
    }
}
