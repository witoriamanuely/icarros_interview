package br.com.br.consumingrest.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RaceDTO {
    String season;
    String round;
    String url;
    String raceName;
    @JsonProperty("Results")
    List<ResultDTO> results;
}
