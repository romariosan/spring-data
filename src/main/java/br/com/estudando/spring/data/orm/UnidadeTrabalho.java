package br.com.estudando.spring.data.orm;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
public class UnidadeTrabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private  String endereco;

    @ManyToMany(mappedBy = "unidadeTrabalhos")
    private List<Funcionario> funcionarios;

}
