package univille.fso.descarte_ideal.CommandLinner;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import univille.fso.descarte_ideal.Entity.PontoDescarte;
import univille.fso.descarte_ideal.Repository.PontoDescarteRepository;

@Configuration
public class InicializadorDados {

    // salva os pontos de descarte no banco
    @Bean
    CommandLineRunner carregarDados(PontoDescarteRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.saveAll(List.of(
                        new PontoDescarte(
                                "Unidade Regional de Obras Centro-Norte",
                                "89220000",
                                "Costa e Silva",
                                "Rua Guilherme",
                                "604",
                                "Segunda a sexta, 08:00 às 17:00",
                                "Resíduos eletroeletrônicos, recicláveis"
                        ),
                        new PontoDescarte(
                                "Unidade Regional de Obras Oeste",
                                "89237000",
                                "Vila Nova",
                                "Rua São Brás",
                                "184",
                                "Segunda a sexta, 08:00 às 17:00",
                                "Resíduos eletrônicos, recicláveis"
                        ),
                        new PontoDescarte(
                                "Unidade Regional de Obras Sudeste",
                                "89233000",
                                "Paranaguamirim",
                                "Rua Ana Maria Roncálio de Souza",
                                "59",
                                "Segunda a sexta, 08:00 às 17:00",
                                "Resíduos eletrônicos, recicláveis"
                        ),
                        new PontoDescarte(
                                "Unidade Regional de Obras Nordeste",
                                "89226000",
                                "Aventureiro",
                                "Rua Theonesto Westrupp",
                                "565",
                                "Segunda a sexta, 08:00 às 17:00",
                                "Resíduos eletrônicos, recicláveis"
                        ),
                        new PontoDescarte(
                                "Ecoponto Parque São Francisco",
                                "89230000",
                                "Adhemar Garcia",
                                "Rua Benício Felipe da Silva",
                                "45",
                                "Segunda a sexta, 08:00 às 17:00",
                                "Recicláveis, resíduos volumosos"
                        )
                ));
            }
        };
    }
}