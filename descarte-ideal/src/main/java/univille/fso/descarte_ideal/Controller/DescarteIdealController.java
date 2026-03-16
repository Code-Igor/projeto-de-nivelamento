package univille.fso.descarte_ideal.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import univille.fso.descarte_ideal.Entity.PontoDescarte;
import org.springframework.ui.Model;
import univille.fso.descarte_ideal.Entity.SolicitacaoColeta;
import univille.fso.descarte_ideal.Service.PontoDescarteService;
import univille.fso.descarte_ideal.Service.SolicitacaoService;

import java.util.List;

@Controller
public class DescarteIdealController {

    private final PontoDescarteService pontoDescarteService;
    private final SolicitacaoService solicitacaoService;

    public DescarteIdealController(PontoDescarteService pontoDescarteService, SolicitacaoService solicitacaoService) {
        this.solicitacaoService = solicitacaoService;
        this.pontoDescarteService = pontoDescarteService;
    }


    @GetMapping("/")
    public String index() {
        return "index";
    }


    // PONTO DE DESCARTE
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

    /// ////////////////////
    ///
    ///
    /// SOLICITACAO DENUNCIA
    @GetMapping("/solicitacao-denuncia")
    public String solicitacaoDenuncia() {
        return "solicitacao-denuncia";
    }


    /// ////////////////////
    ///
    ///
    /// SOLICITACAO COLETA
    @GetMapping("/solicitacao-coleta")
    public String solicitacaoColeta() {
        return "solicitacao-coleta";
    }

    // String nomeCompleto, int cpf, String descricao, int cep, String endereco, Model model
    @PostMapping("/solicitar-coleta")
    public String solicitarColeta(SolicitacaoColeta solicitacao) {
        solicitacaoService.salvarColeta(solicitacao);

        return "redirect:/solicitacao-concluida";
    }


    @GetMapping("/verificacao-status")
    public String verificacaoStatus() {
        return "verificacao-status";
    }
}
