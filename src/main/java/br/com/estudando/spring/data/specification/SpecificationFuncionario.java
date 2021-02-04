package br.com.estudando.spring.data.specification;

import br.com.estudando.spring.data.orm.Funcionario;
import org.springframework.data.jpa.domain.Specification;

public class SpecificationFuncionario {

    public  static Specification<Funcionario> nome(String nome){
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("nome"),"%"+nome+"%"));
    }
    public  static Specification<Funcionario> cpf(String cpf){
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("cpf"),cpf));
    }

    public  static Specification<Funcionario> salario(String salario){
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("salario"),salario));
    }
}
