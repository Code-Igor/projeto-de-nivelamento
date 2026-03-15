package univille.fso.descarte_ideal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import univille.fso.descarte_ideal.Entity.PontoDescarte;

import java.util.List;

public interface PontoDescarteRepository extends JpaRepository<PontoDescarte, Long> {

    List<PontoDescarte> findByNomeContainingIgnoreCase(String nome);

    List<PontoDescarte> findByBairro(String bairro);

    List<PontoDescarte> findByMaterialAceito(String materialAceito);
}
