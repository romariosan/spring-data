package br.com.estudando.spring.data.service;

import br.com.estudando.spring.data.orm.Funcionario;
import br.com.estudando.spring.data.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class FuncionariosService {

    @Autowired
    public FuncionarioRepository funcionarioRepository;


    public void buscarFuncionarioOrdenado(){
        Scanner s=new Scanner(System.in);
        System.out.println("Digite o nome do funcionario");
        String nome = s.nextLine();
        Pageable page= PageRequest.of(1,5);
        List<Funcionario> f= funcionarioRepository.funcionarioPaginado("% "+nome+"%",page);
        f.forEach(func ->{
            System.out.println("Nome do funcionario: "+func.getNome());
        });
    }
}

