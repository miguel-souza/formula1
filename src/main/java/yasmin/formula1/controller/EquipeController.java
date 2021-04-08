package yasmin.formula1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yasmin.formula1.model.dto.EquipeDTO;
import yasmin.formula1.model.dto.EquipesDTO;
import yasmin.formula1.service.EquipeService;

import java.io.IOException;

@RestController
@RequestMapping("/equipes")
public class EquipeController {

    @Autowired
    public EquipeService equipeService;

    @GetMapping
    public ResponseEntity<EquipesDTO> obter() throws IOException, InterruptedException {
        return ResponseEntity.ok(equipeService.obter());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipeDTO> obterPorId(@PathVariable String id) throws IOException, InterruptedException {
        return ResponseEntity.ok(equipeService.obterPorId(id));
    }
}
