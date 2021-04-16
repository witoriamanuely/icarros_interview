package br.com.br.consumingrest.service.dto;

import br.com.br.consumingrest.service.dto.RaceDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RaceTableDTO {

    String season;
    String round;
    @JsonProperty("Races")
    List<RaceDTO> races;
}
