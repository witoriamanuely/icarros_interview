package br.com.br.consumingrest.builder;


import br.com.br.consumingrest.service.dto.FormulaOneDTO;
import br.com.br.consumingrest.service.dto.MRDataDTO;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class FormulaOneBuilder extends ConstrutorDeEntidade<FormulaOneDTO> {

    /** Nesse caso, como temos um consumer a ideia do DTO é aplicada como construção de entidade devido não termos
    * persistencia no banco de dados e entidades de fato, porém a ideia do builder se dá para construir de forma mockada
    * uma entidade com seus atributos setados com alguma informação. Uma boa prática seria setar valores vindos de uma classe util.
     **/
    @Override
    public FormulaOneDTO construirEntidade() throws ParseException {
        FormulaOneDTO formulaOneDTO = new FormulaOneDTO();
        MRDataDTO mrDataDTO = new MRDataDTO();
        mrDataDTO.setLimit("limit");
        mrDataDTO.setOffset("offSet");
        mrDataDTO.setSeries("series");
        mrDataDTO.setTotal("total");
        mrDataDTO.setUrl("url");
        mrDataDTO.setXmlns("xmlns");
        formulaOneDTO.setMrData(mrDataDTO);
        return formulaOneDTO;
    }

    @Override
    protected FormulaOneDTO persistir(FormulaOneDTO entidade) throws ParseException {
        return null;
    }

    @Override
    public FormulaOneDTO obterPorId(Long id) {
        return null;
    }
}
