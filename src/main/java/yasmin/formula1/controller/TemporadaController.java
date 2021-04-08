package yasmin.formula1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yasmin.formula1.model.Temporada;
import yasmin.formula1.model.dto.TemporadasDTO;
import yasmin.formula1.model.dto.TemporadasPorEquipeDTO;
import yasmin.formula1.model.dto.TemporadasPorPilotoDTO;
import yasmin.formula1.service.TemporadaService;

import java.io.IOException;

@RestController
@RequestMapping("/temporadas")
public class TemporadaController {

    @Autowired
    private TemporadaService temporadaService;

    @GetMapping
    public ResponseEntity<TemporadasDTO> obter() throws IOException, InterruptedException {
        return ResponseEntity.ok(temporadaService.obter());
    }

    @GetMapping("/pilotos/{id}")
    public ResponseEntity<TemporadasPorPilotoDTO> obterPorPiloto(@PathVariable String id) throws IOException, InterruptedException {
        return ResponseEntity.ok(temporadaService.obterPorId(id));
    }

    @GetMapping("/equipes/{id}")
    public ResponseEntity<TemporadasPorEquipeDTO> obterPorEquipe(@PathVariable String id) throws IOException, InterruptedException {
        return ResponseEntity.ok(temporadaService.obterPorEquipe(id));
    }
}
