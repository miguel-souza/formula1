package yasmin.formula1.model.dto;

import yasmin.formula1.model.Piloto;

import java.time.LocalDate;
import java.util.Optional;

public class PilotoDTO {
    private String id;
    private String nome;
    private String sobrenome;
    private String dataDeNascimento;
    private String nacionalidade;

    public PilotoDTO(Piloto piloto){
        this.id = piloto.getId();
        this.nome = piloto.getNome();
        this.sobrenome = piloto.getSobrenome();
        this.dataDeNascimento = piloto.getDataDeNascimento();
        this.nacionalidade = piloto.getNacionalidade();
    };

    public PilotoDTO(){};

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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
}
