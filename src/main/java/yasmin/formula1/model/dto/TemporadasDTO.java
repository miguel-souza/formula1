package yasmin.formula1.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import yasmin.formula1.model.MRData;
import yasmin.formula1.model.Temporada;
import yasmin.formula1.model.Temporadas;

import java.util.List;
import java.util.stream.Collectors;

public class TemporadasDTO {

    private String total;

    private List<TemporadaDTO> temporadas;

    public TemporadasDTO(MRData mrData){
        this.total = mrData.getTotal();
        this.temporadas = mrData.getTemporadas().getTemporadas().stream().map(TemporadaDTO::new).collect(Collectors.toList());
    }

    public List<TemporadaDTO> getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(List<TemporadaDTO> temporadas) {
        this.temporadas = temporadas;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
