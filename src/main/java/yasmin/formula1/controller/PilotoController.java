package yasmin.formula1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yasmin.formula1.model.dto.PilotoDTO;
import yasmin.formula1.model.dto.PilotosDTO;
import yasmin.formula1.model.dto.PilotosPorAnoDTO;
import yasmin.formula1.service.PilotoService;

import java.io.IOException;

@RestController
@RequestMapping("/pilotos")
public class PilotoController {

    @Autowired
    private PilotoService pilotoService;

    @GetMapping
    public ResponseEntity<PilotosDTO> obter() throws IOException, InterruptedException {
        return ResponseEntity.ok(pilotoService.obter());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PilotoDTO> obterPorId(@PathVariable(name = "id") String id) throws IOException, InterruptedException {
        return ResponseEntity.ok(pilotoService.obterPorId(id));
    }
}
