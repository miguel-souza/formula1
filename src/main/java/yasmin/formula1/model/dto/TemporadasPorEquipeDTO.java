package yasmin.formula1.model.dto;

import yasmin.formula1.model.MRData;

import java.util.List;
import java.util.stream.Collectors;

public class TemporadasPorEquipeDTO {
    private String equipe;
    private String total;
    private List<TemporadaDTO> temporadas;

    public TemporadasPorEquipeDTO(MRData mrData, String id){
        this.equipe = id;
        this.total = mrData.getTotal();
        this.temporadas = mrData.getTemporadas().getTemporadas().stream().map(TemporadaDTO::new).collect(Collectors.toList());

    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<TemporadaDTO> getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(List<TemporadaDTO> temporadas) {
        this.temporadas = temporadas;
    }
}
