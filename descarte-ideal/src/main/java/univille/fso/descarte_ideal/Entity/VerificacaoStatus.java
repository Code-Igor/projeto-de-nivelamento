package univille.fso.descarte_ideal.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "solicitacao_denuncia")
public class VerificacaoStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStatus;

    @Column
    private Long idColeta;

    @Column
    private Long idDenuncia;

    @Column(nullable = false)
    private boolean tipoSolicitacao;

    @Column(nullable = false)
    private boolean status;

    //
    @Column(nullable = false)
    private LocalDateTime dataCriacao;
}
