package br.com.estudando.spring.data.service;

import br.com.estudando.spring.data.orm.Cargo;
import br.com.estudando.spring.data.repository.CargoPaginaRepository;
import br.com.estudando.spring.data.repository.CargoRepository;
import javafx.scene.control.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class CrudCargoPaginadoService {
    @Autowired
    CargoPaginaRepository cargoRepository;


    public void buscaPaginadaCargos(){
        System.out.println("Tecle enter para obter quantidade paginas: ");

        Pageable pa = PageRequest.of(1,5, Sort.by( Sort.Direction.ASC,"descricao"));
        Page<Cargo> cargos = cargoRepository.findAll(pa);
        System.out.println("Quantidade de paginas: "+cargos.getTotalPages());
        System.out.println("Escolha a pagina: ");
        Scanner scanner =new Scanner(System.in);
        cargos.forEach(cargo->{
            System.out.println("Descricao "+ cargo.getDescricao());
        });
    }


}
