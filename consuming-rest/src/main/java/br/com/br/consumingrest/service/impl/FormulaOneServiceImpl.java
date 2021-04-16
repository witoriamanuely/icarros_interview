package br.com.br.consumingrest.service.impl;

import br.com.br.consumingrest.config.ApplicationProperties;
import br.com.br.consumingrest.service.FormulaOneService;
import br.com.br.consumingrest.service.dto.FormulaOneDTO;
import br.com.br.consumingrest.service.dto.MRDataDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class FormulaOneServiceImpl implements FormulaOneService {

    public FormulaOneServiceImpl(){
        this.restTemplate = new RestTemplate();
    }
    private final RestTemplate restTemplate;


    @Override
    public FormulaOneDTO findALlJson(){
        FormulaOneDTO formulaOne = this.restTemplate.getForObject(ApplicationProperties.URL, FormulaOneDTO.class);
        return formulaOne;
    }
}
