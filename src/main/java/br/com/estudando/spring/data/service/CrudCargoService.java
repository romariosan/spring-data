package br.com.estudando.spring.data.service;

import br.com.estudando.spring.data.orm.Cargo;
import br.com.estudando.spring.data.orm.CargosProjecao;
import br.com.estudando.spring.data.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class CrudCargoService {
    @Autowired
    CargoRepository cargoRepository;

    public void salvarCargo(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Digite a descricao do cargo: ");
        String descricao=scanner.next();
        Cargo cargo=new Cargo();
        cargo.setDescricao(descricao);
        cargoRepository.save(cargo);
        System.out.println("Sucesso ao criar novo cargo!!");
    }

    public void atualizar(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Digite a descricao já salva: ");
        String descricao=scanner.next();
        AtomicBoolean isExisteCargo = new AtomicBoolean(false);
        AtomicReference<Cargo> cargoEncotrado= new AtomicReference<>(new Cargo());
        cargoRepository.findAll().forEach(cargo ->{
            if(cargo.getDescricao().toLowerCase().contains(descricao.toLowerCase())){
                cargoEncotrado.set(cargo);
                isExisteCargo.set(true);
            }
       } );
        if(isExisteCargo.get()){
            System.out.println("Digite a NOVA DESCRICAO já salva: ");
            String novaDescricao=scanner.next();
            Cargo cargo=new Cargo();
            cargo.setId(cargoEncotrado.get().getId());
            cargo.setDescricao(novaDescricao);
            cargoRepository.save(cargo);
            System.out.println("Sucesso ao atualizar cargo!!");

        }
        else{
            System.out.println("Não encontrado ");

        }
    }

    public    void buscarPorNome(){
        Scanner scaner =new Scanner(System.in);
        System.out.println("Buscar por nome ");
        String nome =scaner.next();
        cargoRepository.buscaPorNomeNativeQuery(nome).forEach(cargo ->{
            System.out.println(cargo.getDescricao());

        });

    }

    public void todosCargos(){
        List<CargosProjecao> todos=cargoRepository.buscarCargos();
        todos.forEach(c->{
            System.out.println("Nome: "+c.getDescricao());
        });
    }
}
