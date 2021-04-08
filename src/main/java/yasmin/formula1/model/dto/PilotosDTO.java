package yasmin.formula1.model.dto;

import yasmin.formula1.model.MRData;

import java.util.List;
import java.util.stream.Collectors;

public class PilotosDTO {

    private String total;
    private List<PilotoDTO> pilotos;

    public PilotosDTO(MRData mrData){
        this.total = mrData.getTotal();
        this.pilotos = mrData.getPilotos().getPilotos().stream().map(PilotoDTO::new).collect(Collectors.toList());
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<PilotoDTO> getPilotos() {
        return pilotos;
    }

    public void setPilotos(List<PilotoDTO> pilotos) {
        this.pilotos = pilotos;
    }
}
