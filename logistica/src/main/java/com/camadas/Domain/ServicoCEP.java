package com.camadas.Domain;

import org.springframework.stereotype.Service;

import com.bcopstein.SistCalculoFreteP3.util.ConsultaViaCEP;
import com.bcopstein.SistCalculoFreteP3.util.MontaPesquisaCEP;
import com.bcopstein.SistCalculoFreteP3.util.ResultadoPesquisaCEP;

@Service
public class ServicoCEP {
    // Retorna a cidade correspondente ao CEP ou
    // "invalido" se o CEP for invalido ou
    // "nao atendida" se o CEP é válido mas a cidade não é atendida
    // "excecao" se houve problema na consulta
    public ResultadoPesquisaCEP pesquisaCEP(String umCEP) throws Exception {
        ConsultaViaCEP cvc = new ConsultaViaCEP();
        if (!umCEP.isBlank()) {
            var pesquisa = new MontaPesquisaCEP();
            pesquisa.setCep(umCEP);
            var consulta = pesquisa.consultaPorCEP();
            var resp = cvc.submeteConsultaCEP(consulta);
            return resp;

        } else {
            return null;
        }
    }
}
