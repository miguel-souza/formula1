package yasmin.formula1.model.dto;

import yasmin.formula1.model.Temporada;

public class TemporadaDTO {
    private String url;

    private String ano;

    public TemporadaDTO(Temporada temporada) {
        this.url = temporada.getUrl();
        this.ano = temporada.getSeason();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
}
