package univille.fso.descarte_ideal.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "solicitacao_coleta")
public class SolicitacaoColeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeCompleto;

    @Column (nullable = false, length = 11)
    private String cpf;

    @Column
    private String descricaoObjeto;

    @Column (nullable = false, length = 8)
    private String cep;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private LocalDateTime dataCriacao;

    // pega o valor da data atual assim que for chamado
    public SolicitacaoColeta() {
        this.dataCriacao = LocalDateTime.now();
    }
}
