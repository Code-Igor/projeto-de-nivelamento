package univille.fso.descarte_ideal.Service;

import org.springframework.stereotype.Service;
import univille.fso.descarte_ideal.Entity.PontoDescarte;
import univille.fso.descarte_ideal.Repository.PontoDescarteRepository;

import java.util.List;

@Service
public class PontoDescarteService {

    //parametros
    private final PontoDescarteRepository pontoDescarteRepository;

    // construtor
    public PontoDescarteService(PontoDescarteRepository pontoDescarteRepository)  {
        this.pontoDescarteRepository = pontoDescarteRepository;
    }

    // metodos
    public List<PontoDescarte> pesquisarPorNome (String nome) {return pontoDescarteRepository.findByNomeContainingIgnoreCase(nome);}

    public List<PontoDescarte> filtrarPorBairro (String bairro) {
        return pontoDescarteRepository.findByBairro(bairro);
    }

    public List<PontoDescarte> filtrarPorTipoDescarte (String materialAceito) {return pontoDescarteRepository.findByMaterialAceito(materialAceito);}
}
