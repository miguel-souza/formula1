package yasmin.formula1.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import yasmin.formula1.controller.exception.ErroInternoException;
import yasmin.formula1.controller.exception.NotFoundException;
import yasmin.formula1.model.Data;
import yasmin.formula1.model.Temporada;
import yasmin.formula1.model.dto.TemporadasDTO;
import yasmin.formula1.model.dto.TemporadasPorEquipeDTO;
import yasmin.formula1.model.dto.TemporadasPorPilotoDTO;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class TemporadaService {

    ObjectMapper objectMapper = new ObjectMapper();
    private static final String TEMPORADAS_URI = "http://ergast.com/api/f1/";

    public TemporadasDTO obter() throws IOException, InterruptedException {
        Data data = objectMapper.readValue(obterArquivo(TEMPORADAS_URI + "seasons.json"), Data.class);
        return new TemporadasDTO(data.getMrData());
    }

    public TemporadasPorPilotoDTO obterPorId(String id) throws IOException, InterruptedException {
        String path = "drivers/" +  id + "/seasons.json";
        Data data = objectMapper.readValue(obterArquivo(TEMPORADAS_URI + path), Data.class);

        if(data.getMrData().getTemporadas().getTemporadas().isEmpty())
            throw new NotFoundException("Não foram encontradas temporadas para o id do piloto informado: " + id);

        return new TemporadasPorPilotoDTO(data, id);
    }

    public TemporadasPorEquipeDTO obterPorEquipe(String id) throws IOException, InterruptedException {
        String path = "constructors/" + id + "/seasons.json";
        Data data = objectMapper.readValue(obterArquivo(TEMPORADAS_URI + path), Data.class);

        if(data.getMrData().getTemporadas().getTemporadas().isEmpty())
            throw new NotFoundException("Não foram encontradas temporadas para o id da equipe informado: " + id);

        return new TemporadasPorEquipeDTO(data.getMrData(), id);
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
