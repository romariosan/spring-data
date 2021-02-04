package br.com.estudando.spring.data.orm;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private String descricao;

    @OneToMany(mappedBy = "cargo")
    List<Funcionario> funcionarios;
}
