package br.com.estudando.spring.data.service;

import br.com.estudando.spring.data.orm.Funcionario;
import br.com.estudando.spring.data.repository.FuncionarioRepository;
import br.com.estudando.spring.data.specification.SpecificationFuncionario;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;
@Service
public class FuncionarioSpecification {

public FuncionarioRepository  funcionarioRepository;

    public  FuncionarioSpecification( FuncionarioRepository  funcionarioRepository){
        this.funcionarioRepository=funcionarioRepository;
    }

    public void iniciar(){
        System.out.println("Entre com nome:");
        Scanner scanner1 =new Scanner(System.in);
        String nome =  scanner1.next();

        System.out.println("Entre com cpf:");
        Scanner scanner2 =new Scanner(System.in);
        String cpf =  scanner2.next();

        System.out.println("Entre com salario:");
        Scanner scanner3 =new Scanner(System.in);
        String salario =  scanner3.next();
        if(nome.equals("null")){
            nome=null;
        }
        else if(cpf.equals("null")){
            cpf=null;

        }
        else if(salario.equals("null")){
            salario=null;
        }

        List<Funcionario> fs=funcionarioRepository.findAll(Specification.where(SpecificationFuncionario.nome(nome)).or(SpecificationFuncionario.cpf(cpf)).or(SpecificationFuncionario.salario(salario)));

        fs.forEach(f->{
            System.out.println("Nome:"+f.getNome());
            System.out.println("Cpf:"+f.getCpf());
            System.out.println("Salario:"+f.getSalario());
            System.out.println();
            System.out.println();
        });

    }

}
