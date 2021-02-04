package br.com.estudando.spring.data.repository;

import br.com.estudando.spring.data.orm.Cargo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargoPaginaRepository extends PagingAndSortingRepository<Cargo,Integer> {




}
