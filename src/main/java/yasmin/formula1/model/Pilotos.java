package yasmin.formula1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pilotos {

    @JsonProperty("season")
    private String ano;

    @JsonProperty("Drivers")
    private List<Piloto> pilotos;

    public List<Piloto> getPilotos() {
        return pilotos;
    }

    public void setPilotos(List<Piloto> pilotos) {
        this.pilotos = pilotos;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
}
