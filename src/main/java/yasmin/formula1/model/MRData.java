package yasmin.formula1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MRData {

    @JsonProperty("total")
    private String total;

    @JsonProperty("SeasonTable")
    private Temporadas temporadas;

    @JsonProperty("DriverTable")
    private Pilotos pilotos;

    @JsonProperty("ConstructorTable")
    private Equipes equipes;

    public Temporadas getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(Temporadas temporadas) {
        this.temporadas = temporadas;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Pilotos getPilotos() {
        return pilotos;
    }

    public void setPilotos(Pilotos pilotos) {
        this.pilotos = pilotos;
    }

    public Equipes getEquipes() {
        return equipes;
    }

    public void setEquipes(Equipes equipes) {
        this.equipes = equipes;
    }
}
