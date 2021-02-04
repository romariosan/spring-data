package br.com.estudando.spring.data.repository;

import br.com.estudando.spring.data.orm.Cargo;
import br.com.estudando.spring.data.orm.Funcionario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository  extends PagingAndSortingRepository<Funcionario,Integer>, JpaSpecificationExecutor<Funcionario> {

    @Query("SELECT f FROM Funcionario  f where f.nome LIKE :nome ")
    List<Funcionario> funcionarioPaginado(String nome, Pageable pageable);

}
