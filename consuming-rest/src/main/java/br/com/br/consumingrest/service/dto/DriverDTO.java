package br.com.br.consumingrest.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DriverDTO {
    String driverId;
    String permanentNumber;
    String code;
    String url;
    String givenName;
    String familyName;
    String dateOfBirth;
    String nationality;
}
