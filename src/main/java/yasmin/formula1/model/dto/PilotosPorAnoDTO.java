package yasmin.formula1.model.dto;

import yasmin.formula1.model.MRData;

import java.util.List;
import java.util.stream.Collectors;

public class PilotosPorAnoDTO {

    private String ano;
    private String total;
    private List<PilotoDTO> pilotos;

    public PilotosPorAnoDTO(MRData mrData){
        this.ano = mrData.getPilotos().getAno();
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

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
}
