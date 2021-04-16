package br.com.br.consumingrest.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultDTO {

        String number;
        String position;
        String positioText;
        String points;
        @JsonProperty("Driver")
        DriverDTO driver;
        @JsonProperty("Constructor")
        ConstructorDTO constructor;
        String grid;
        String laps;
        String status;

}


