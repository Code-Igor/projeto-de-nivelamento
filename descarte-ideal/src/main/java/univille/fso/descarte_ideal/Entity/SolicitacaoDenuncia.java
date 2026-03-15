package univille.fso.descarte_ideal.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "solicitacao_denuncia")
public class SolicitacaoDenuncia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column (nullable = false, length = 8)
    private String cep;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private LocalDateTime dataCriacao;

    // pega o valor da data atual assim que for chamado
    public SolicitacaoDenuncia() {
        this.dataCriacao = LocalDateTime.now();
    }
}
