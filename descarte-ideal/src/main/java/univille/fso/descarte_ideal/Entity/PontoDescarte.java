package univille.fso.descarte_ideal.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "ponto_descarte")
public class PontoDescarte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column (nullable = false, length = 8)
    private String cep;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String rua;

    @Column(nullable = false)
    private String numero;

    @Column(nullable = false)
    private String horarioFuncionamento;

    @Column(nullable = false)
    private String materialAceito;


    public PontoDescarte(String nome, String cep, String bairro, String rua, String numero, String horarioFuncionamento, String materialAceito) {
        this.nome = nome;
        this.cep = cep;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.horarioFuncionamento = horarioFuncionamento;
        this.materialAceito = materialAceito;
    }
}
