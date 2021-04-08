package yasmin.formula1.model.dto;

import yasmin.formula1.model.Data;
import yasmin.formula1.model.dto.TemporadaDTO;

import java.util.List;
import java.util.stream.Collectors;

public class TemporadasPorPilotoDTO {
    private String piloto;
    private String total;
    private List<TemporadaDTO> temporadas;

    public TemporadasPorPilotoDTO(Data data, String id){
        this.piloto = id;
        this.total = data.getMrData().getTotal();
        this.temporadas = data.getMrData().getTemporadas().getTemporadas().stream().map(TemporadaDTO::new).collect(Collectors.toList());
    }

    public String getPiloto() {
        return piloto;
    }

    public void setPiloto(String piloto) {
        this.piloto = piloto;
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
