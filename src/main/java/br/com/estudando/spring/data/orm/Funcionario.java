package br.com.estudando.spring.data.orm;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cpf;
    private String salario;
    private Date dataContratacao;

    @ManyToOne
    @JoinColumn(name = "cargoId")
    private Cargo cargo;

    @ManyToMany
    @JoinTable(name = "funcionario_UnidadeTrabalho", joinColumns = {@JoinColumn(name = "fk_funcionario")},
            inverseJoinColumns = {@JoinColumn(name = "fk_unidadeTrabalho")})
    private List<UnidadeTrabalho> unidadeTrabalhos;
}
