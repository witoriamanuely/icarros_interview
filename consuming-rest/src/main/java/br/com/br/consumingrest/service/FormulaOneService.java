package br.com.br.consumingrest.service;

import br.com.br.consumingrest.service.dto.DriverDTO;
import br.com.br.consumingrest.service.dto.FormulaOneDTO;
import br.com.br.consumingrest.service.dto.RaceDTO;
import br.com.br.consumingrest.service.dto.ResultDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FormulaOneService {

    FormulaOneDTO findAllJson();

    List<RaceDTO> findRaceByRound(Integer round);

    List<List<ResultDTO>> findResultByRound(Integer round);

    List<List<ResultDTO>> findResult();

    List<RaceDTO> findRace();

    List<String> findRaceNames();

    List<List<DriverDTO>> findAllDrivers();

    void sendRaces(Integer id);

    void deleteRaces(Integer id);

    void sendAll(FormulaOneDTO formulaOneDTO);

}
