package univille.fso.descarte_ideal.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import univille.fso.descarte_ideal.Entity.PontoDescarte;
import org.springframework.ui.Model;
import univille.fso.descarte_ideal.Service.PontoDescarteService;

import java.util.List;

@Controller
public class DescarteIdealController {

    PontoDescarteService pontoDescarteService;

    public DescarteIdealController(PontoDescarteService pontoDescarteService) {
        this.pontoDescarteService = pontoDescarteService;
    }


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/ponto-descarte")
    public String pontoDescarte(Model model) {

        // lista dos pontos de descarte
        List<PontoDescarte> pontos = pontoDescarteService.listarTodos();

        model.addAttribute("pontos", pontos);
        return "ponto-descarte";
    }

    @GetMapping("/pesquisar")
    public String pesquisar(String pesquisa, Model model) {

        // pesquisa os pontos, com base no que foi para o banco em 'inicializador daodos'
        List<PontoDescarte> pontosPesquisa = pontoDescarteService.pesquisarPorNome(pesquisa);

        // mantendo o nome "pontos", para alterar quando realizar a pesquisa
        model.addAttribute("pontos", pontosPesquisa);

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
