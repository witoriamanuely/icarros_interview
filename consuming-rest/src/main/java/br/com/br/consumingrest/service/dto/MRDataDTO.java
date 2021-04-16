package br.com.br.consumingrest.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MRDataDTO {

    String xmlns;
    String series;
    String url;
    String limit;
    String offset;
    String total;
    @JsonProperty("RaceTable")
    RaceTableDTO raceTable;

}
