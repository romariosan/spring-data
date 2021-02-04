package br.com.estudando.spring.data.repository;

import br.com.estudando.spring.data.orm.Cargo;
import br.com.estudando.spring.data.orm.CargosProjecao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Integer> {

    List<Cargo>  findByDescricao(String nome);

    @Query("SELECT c FROM Cargo c where c.descricao = :descricao")
    List<Cargo> buscarPorNome(String descricao);

    @Query(value = "SELECT *FROM cargo c WHERE c.descricao =:descricao ",nativeQuery = true)
    List<Cargo> buscaPorNomeNativeQuery(String descricao);

    @Query(value = "SELECT c.descricao as descricao FROM cargo c", nativeQuery = true)
    List<CargosProjecao> buscarCargos();
}
