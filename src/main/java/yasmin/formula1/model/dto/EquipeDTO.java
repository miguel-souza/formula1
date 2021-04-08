package yasmin.formula1.model.dto;

import yasmin.formula1.controller.exception.NotFoundException;
import yasmin.formula1.model.Equipe;

import java.util.Optional;

public class EquipeDTO {
    private String id;
    private String nome;
    private String nacionalidade;

    public EquipeDTO(Equipe equipe){
        this.id = equipe.getId();
        this.nome = equipe.getNome();
        this.nacionalidade = equipe.getNacionalidade();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
}
