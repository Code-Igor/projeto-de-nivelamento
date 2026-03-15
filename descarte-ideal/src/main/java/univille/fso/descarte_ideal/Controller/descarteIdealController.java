package univille.fso.descarte_ideal.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class descarteIdealController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/ponto-descarte")
    public String pontoDescarte() {


        return "ponto-descarte";
    }

    @GetMapping("/solicitacao-denuncia")
    public String solicitacaoDenuncia() {
        return "solicitacao-denuncia";
    }

    @GetMapping("/solicitacao-coleta")
    public String solicitacaoColeta() {
        return "solicitacao-coleta";
    }

    @GetMapping("/verificacao-status")
    public String verificacaoStatus() {
        return "verificacao-status";
    }
}
