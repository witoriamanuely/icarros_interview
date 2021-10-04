package br.com.br.consumingrest.service.impl;

import br.com.br.consumingrest.exception.BadRequestException;
import br.com.br.consumingrest.service.FormulaOneService;
import br.com.br.consumingrest.service.dto.DriverDTO;
import br.com.br.consumingrest.service.dto.FormulaOneDTO;
import br.com.br.consumingrest.service.dto.RaceDTO;
import br.com.br.consumingrest.service.dto.ResultDTO;
import br.com.br.consumingrest.service.utils.ConstantsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FormulaOneServiceImpl implements FormulaOneService {

    public FormulaOneServiceImpl(@Value("${application.formula-one.url}") String url){
        this.restTemplate = new RestTemplate();
        this.url = url;
    }

    private final String url;
    private final RestTemplate restTemplate;

    public FormulaOneDTO searchFormulaOneDTO(){
        log.info(this.url);
        return this.restTemplate.getForObject(this.url, FormulaOneDTO.class);
    }

    public List<RaceDTO> searchRaceDTOByRound(Integer round){
        FormulaOneDTO formulaOneDTO = searchFormulaOneDTO();
        return formulaOneDTO.getMrData().getRaceTable().getRaces().stream().filter(race -> race.getRound().equals(round.toString())).collect(Collectors.toList());
    }

    public List<RaceDTO> searchRaceDTO(){
        FormulaOneDTO formulaOneDTO = searchFormulaOneDTO();
        return formulaOneDTO.getMrData().getRaceTable().getRaces();
    }

    @Override
    public FormulaOneDTO findAllJson(){
        FormulaOneDTO formulaOne = searchFormulaOneDTO();
        return formulaOne;
    }

    @Override
    public List<RaceDTO> findRaceByRound(Integer round){
        return searchRaceDTOByRound(round);
    }

    @Override
    public List<List<ResultDTO>> findResultByRound(Integer round){
        List<RaceDTO> raceDTOS = searchRaceDTOByRound(round);
        return raceDTOS.stream().map(element -> element.getResults()).collect(Collectors.toList());
    }

    @Override
    public List<List<ResultDTO>> findResult(){
        List<RaceDTO> raceDTOS = searchRaceDTO();
        return raceDTOS.stream().map(element -> element.getResults()).collect(Collectors.toList());
    }

    @Override
    public List<RaceDTO> findRace(){
        return searchRaceDTO();
    }

    @Override
    public List<String> findRaceNames(){
        List<RaceDTO> raceDTOS = searchRaceDTO();

        return raceDTOS.stream().map(raceName -> raceName.getRaceName()).collect(Collectors.toList());
    }

    @Override
    public List<List<DriverDTO>> findAllDrivers(){
        List<RaceDTO> raceDTOS = searchRaceDTO();
        return raceDTOS.stream().map(race -> race.getResults().stream().map(e -> e.getDriver()).collect(Collectors.toList())).collect(Collectors.toList());
    }

    @Override
    public void sendRaces(Integer id ){
        if (!id.equals(1)){
            throw new BadRequestException(ConstantsUtil.ERROR_BAD_REQUEST, ConstantsUtil.ERROR_TITLE);
        }
        System.out.println(String.format("Teste de unidade POST request: {}", id));
    }

    @Override
    public void deleteRaces(Integer id ){
        System.out.println(String.format("Teste de unidade DELETE request: {}", id));
    }

    @Override
    public void sendAll(FormulaOneDTO formulaOneDTO ){
        System.out.println(String.format("Teste de unidade POST request: {}", formulaOneDTO));
    }
}
