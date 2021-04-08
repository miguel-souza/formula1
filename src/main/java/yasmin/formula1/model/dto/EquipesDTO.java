package yasmin.formula1.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import yasmin.formula1.model.MRData;

import java.util.List;
import java.util.stream.Collectors;

public class EquipesDTO {

    private String total;
    private List<EquipeDTO> equipes;

    public EquipesDTO(MRData mrData) {
        this.total = mrData.getTotal();
        this.equipes = mrData.getEquipes().getEquipes().stream().map(EquipeDTO::new).collect(Collectors.toList());
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<EquipeDTO> getEquipes() {
        return equipes;
    }

    public void setEquipes(List<EquipeDTO> equipes) {
        this.equipes = equipes;
    }
}
