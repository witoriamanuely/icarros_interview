package br.com.br.consumingrest.web.rest;

import br.com.br.consumingrest.builder.FormulaOneBuilder;
import br.com.br.consumingrest.service.FormulaOneService;
import br.com.br.consumingrest.service.dto.FormulaOneDTO;
import br.com.br.consumingrest.test.AbstractTest;
import br.com.br.consumingrest.web.rest.util.TestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class FormulaOneTest extends AbstractTest<FormulaOneResource> {
    private static final String API_FORMULA_ONE = "/api/";

    @Autowired
    FormulaOneService formulaOneService;

    @Autowired
    FormulaOneBuilder builder;

    /** Método  que chama a classe abstrata que inicia o Resource e Service no construtor **/
    @BeforeEach
    public void setUp() {
        super.init(new FormulaOneResource(formulaOneService));
    }

    /** Caso de teste para GET / esperando status = 200 **/
    @Test
    @DisplayName("List all")
    public void listAll() throws Exception {
        getMockMvc().perform(get(API_FORMULA_ONE)).andExpect(status().isOk());
    }

    /** Caso de teste para GET /api esperando status = 404. Esse caso é só pra demonstrar um andExepct diferente **/
    @Test
    @DisplayName("List all not found")
    public void listAllNotFound() throws Exception {
        getMockMvc().perform(get(API_FORMULA_ONE+"/random")).andExpect(status().isNotFound());
    }

    /** Caso de teste para GET /api/races/{id} esperando status = 200 **/
    @Test
    @DisplayName("List Race of Round")
    public void listRaceOfRound() throws Exception {
        Integer roundId = 20;
        String API_FORMULA_ONE_RACCES_ROUNDID = API_FORMULA_ONE+"/races/"+roundId;
        getMockMvc().perform(get(API_FORMULA_ONE_RACCES_ROUNDID)).andExpect(status().isOk());
    }

    /** Caso de teste para GET /api/races/{id}/results esperando status = 200 **/
    @Test
    @DisplayName("List all results of round")
    public void listResultsOfRound() throws Exception {
        Integer roundId = 20;
        String API_FORMULA_ONE_RACCES_ROUNDID_RESULTS = API_FORMULA_ONE+"/races/"+roundId+"/results";
        getMockMvc().perform(get(API_FORMULA_ONE_RACCES_ROUNDID_RESULTS)).andExpect(status().isOk());
    }

    /** Caso de teste para GET /api/races/results esperando status = 200 **/
    @Test
    @DisplayName("List all results")
    public void listAllResults() throws Exception {
        String API_FORMULA_ONE_RACCES_ROUNDID_RESULTS = API_FORMULA_ONE+"/races/results";
        getMockMvc().perform(get(API_FORMULA_ONE_RACCES_ROUNDID_RESULTS)).andExpect(status().isOk());
    }

    /** Caso de teste para GET /api/races esperando status = 200 **/
    @Test
    @DisplayName("List all races")
    public void listAllRaces() throws Exception {
        String API_FORMULA_ONE_RACES = API_FORMULA_ONE+"/races";
        getMockMvc().perform(get(API_FORMULA_ONE_RACES)).andExpect(status().isOk());
    }

    /** Caso de teste para GET /api/races/name esperando status = 200 **/
    @Test
    @DisplayName("List all races names")
    public void listAllRacesNames() throws Exception {
        String API_FORMULA_ONE_RACES_NAME = API_FORMULA_ONE+"/races/name";
        getMockMvc().perform(get(API_FORMULA_ONE_RACES_NAME)).andExpect(status().isOk());
    }

    /** Caso de teste para GET /api/races/drivers esperando status = 200 **/
    @Test
    @DisplayName("List all races drivers")
    public void listAllDrivers() throws Exception {
        String API_FORMULA_ONE_RACES_DRIVERS = API_FORMULA_ONE+"/races/drivers";
        getMockMvc().perform(get(API_FORMULA_ONE_RACES_DRIVERS)).andExpect(status().isOk());
    }

    /** Caso de teste para POST /api/{id} esperando status = 200
    * Embora essa api se trate de um consumer eu resolvi demonstrar uma cobertura de testes
    * utilizando do getMockMvc()...post() a fim de agregar exemplo
     **/
    @Test
    @DisplayName("Send race by id")
    public void sendRaces() throws Exception {
        Integer id = 1;
        getMockMvc()
                .perform(post(API_FORMULA_ONE+"/{id}", id).contentType(TestUtil.APPLICATION_JSON_UTF8)
                        .content(TestUtil.convertObjectToJsonBytes(id)))
                .andExpect(status().isOk());
    }

    /** Caso de teste para POST /api/{id} esperando status = 400 **/
    @Test
    @DisplayName("Send race by id Bad Request")
    public void sendRacesBadRequest() throws Exception {
        Integer id = 0;
        getMockMvc()
                .perform(post(API_FORMULA_ONE+"/{id}", id).contentType(TestUtil.APPLICATION_JSON_UTF8)
                        .content(TestUtil.convertObjectToJsonBytes(id)))
                .andExpect(status().isBadRequest());
    }

    /** Caso de teste para DELETE /api/{id} esperando status = 200 **/
    @Test
    @DisplayName("Delete race by id")
    public void deleteRaces() throws Exception {
        Integer id = 1;
        getMockMvc()
                .perform(delete(API_FORMULA_ONE+"/{id}", id).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    /** Caso de teste para POST /api esperando status = 200 **/
    @Test
    @DisplayName("Send all")
    public void sendAll() throws Exception {
        FormulaOneDTO formulaOneDTO = builder.construirEntidade();
        getMockMvc()
                .perform(post(API_FORMULA_ONE).contentType(TestUtil.APPLICATION_JSON_UTF8)
                        .content(TestUtil.convertObjectToJsonBytes(formulaOneDTO)))
                .andExpect(status().isOk());
    }
}
