package br.com.br.consumingrest.service;

import br.com.br.consumingrest.service.dto.FormulaOneDTO;
import org.springframework.stereotype.Service;

@Service
public interface FormulaOneService {

    public FormulaOneDTO findALlJson();
}
