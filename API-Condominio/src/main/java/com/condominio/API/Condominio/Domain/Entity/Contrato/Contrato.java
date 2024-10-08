package com.condominio.API.Condominio.Domain.Entity.Contrato;

import com.condominio.API.Condominio.Domain.Entity.Apartamento.Apartamento;
import com.condominio.API.Condominio.Domain.Entity.Pessoa.Pessoa;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Table(name = "Contratos")
@Entity(name = "Contrato")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataPagamento;
    private Integer tempoContrato;
    private BigDecimal aluguel;

    @ElementCollection
    private List<ParcelaCaucao> calcaoParcelado;

    @OneToMany(mappedBy = "contrato")
    private List<Pessoa> pessoas;

    @OneToOne
    @JoinColumn(name = "apartamento_id")
    private Apartamento apartamento;

    //boolean vigente, mudar o relacionamento de um para muitos
    //pois posso ter varios controatos antigos e o atual deixar como vigente
    //para poder olhar os contratos anteriores

    public Contrato(DadosCadastroContrato dados, List<Pessoa> idPessoas, Apartamento apartamentoPassado){
        this.aluguel = dados.aluguel();
        this.apartamento = apartamentoPassado;
        this.tempoContrato = dados.tempoContrato();
        this.dataPagamento = dados.dataPagamento();
        this.pessoas = idPessoas;
        apartamentoPassado.setDisponivel(false);


    }


}
