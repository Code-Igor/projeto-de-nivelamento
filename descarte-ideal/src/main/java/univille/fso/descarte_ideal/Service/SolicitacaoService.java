package univille.fso.descarte_ideal.Service;

import org.springframework.stereotype.Service;
import univille.fso.descarte_ideal.Entity.PontoDescarte;
import univille.fso.descarte_ideal.Entity.SolicitacaoColeta;
import univille.fso.descarte_ideal.Entity.SolicitacaoDenuncia;
import univille.fso.descarte_ideal.Repository.PontoDescarteRepository;
import univille.fso.descarte_ideal.Repository.SolicitacaoColetaRepository;
import univille.fso.descarte_ideal.Repository.SolicitacaoDenunciaRepository;

import java.util.List;

@Service
public class SolicitacaoService {

    private final SolicitacaoColetaRepository solicitacaoColetaRepository;
    private final SolicitacaoDenunciaRepository solicitacaoDenunciaRepository;

    // construtor
    public SolicitacaoService(SolicitacaoColetaRepository solicitacaoColetaRepository, SolicitacaoDenunciaRepository solicitacaoDenunciaRepository)  {
        this.solicitacaoColetaRepository = solicitacaoColetaRepository;
        this.solicitacaoDenunciaRepository = solicitacaoDenunciaRepository;
    }

    //metodos
    public void salvarColeta(SolicitacaoColeta solicitacao) {
        solicitacaoColetaRepository.save(solicitacao);
    }

    public void salvarDenuncia(SolicitacaoDenuncia solicitacao) {
        solicitacaoDenunciaRepository.save(solicitacao);
    }
}
