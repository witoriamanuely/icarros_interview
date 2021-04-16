package br.com.br.consumingrest.web.rest;

import br.com.br.consumingrest.service.FormulaOneService;
import br.com.br.consumingrest.service.dto.DriverDTO;
import br.com.br.consumingrest.service.dto.FormulaOneDTO;
import br.com.br.consumingrest.service.dto.RaceDTO;
import br.com.br.consumingrest.service.dto.ResultDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class FormulaOneResource {

    private final FormulaOneService service;


    @GetMapping
    public ResponseEntity<FormulaOneDTO> findAll() {
        FormulaOneDTO formulaOneDTO  = service.findAllJson();
        log.debug("REST request to get all json: {}", formulaOneDTO);
        return new ResponseEntity<>(formulaOneDTO, HttpStatus.OK);
    }

    @GetMapping("/races/{round}")
    public ResponseEntity<List<RaceDTO>> findRaceOfRound(@PathVariable Integer round) {
        List<RaceDTO> raceDTO = service.findRaceByRound(round);
        log.debug("REST request to get race by round: {}", raceDTO);
        return new ResponseEntity<>(raceDTO, HttpStatus.OK);
    }

    @GetMapping("/races/{round}/results")
    public ResponseEntity<List<List<ResultDTO>>> findResultsOfRound(@PathVariable Integer round) {
        List<List<ResultDTO>> resultDTOS  = service.findResultByRound(round);
        log.debug("REST request to get results by round: {}", resultDTOS);
        return new ResponseEntity<>(resultDTOS, HttpStatus.OK);
    }

    @GetMapping("r/aces/results")
    public ResponseEntity<List<List<ResultDTO>>> findAllResults() {
        List<List<ResultDTO>> resultDTOS  = service.findResult();
        log.debug("REST request to get all results: {}", resultDTOS);
        return new ResponseEntity<>(resultDTOS, HttpStatus.OK);
    }

    @GetMapping("/races")
    public ResponseEntity<List<RaceDTO>> findAllRaces() {
        List<RaceDTO> resultDTOS  = service.findRace();
        log.debug("REST request to get all races: {}", resultDTOS);
        return new ResponseEntity<>(resultDTOS, HttpStatus.OK);
    }

    @GetMapping("/races/name")
    public ResponseEntity<List<String>> findRaceNames() {
        List<String> raceNames  = service.findRaceNames();
        log.debug("REST request to get race names: {}", raceNames);
        return new ResponseEntity<>(raceNames, HttpStatus.OK);
    }

    @GetMapping("/races/drivers")
    public ResponseEntity<List<List<DriverDTO>>> findDrivers() {
        List<List<DriverDTO>> raceNames  = service.findAllDrivers();
        log.debug("REST request to get all drivers: {}", raceNames);
        return new ResponseEntity<>(raceNames, HttpStatus.OK);
    }

}
