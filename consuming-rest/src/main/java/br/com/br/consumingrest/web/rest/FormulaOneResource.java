package br.com.br.consumingrest.web.rest;

import br.com.br.consumingrest.service.FormulaOneService;
import br.com.br.consumingrest.service.dto.FormulaOneDTO;
import br.com.br.consumingrest.service.dto.MRDataDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class FormulaOneResource {

    private final FormulaOneService service;

    @PostMapping("")
    public ResponseEntity<MRDataDTO> post() {
        log.debug("REST request POST");
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @GetMapping("get")
    public ResponseEntity<FormulaOneDTO> findAll() {
        FormulaOneDTO formulaOneDTO  = service.findALlJson();
        log.debug("REST request to get :{}", formulaOneDTO);
        return new ResponseEntity<>(formulaOneDTO, HttpStatus.OK);
    }

}
