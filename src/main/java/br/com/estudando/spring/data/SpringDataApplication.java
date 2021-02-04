package br.com.estudando.spring.data;

import br.com.estudando.spring.data.service.CrudCargoPaginadoService;
import br.com.estudando.spring.data.service.CrudCargoService;
import br.com.estudando.spring.data.service.FuncionarioSpecification;
import br.com.estudando.spring.data.service.FuncionariosService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;


//CommandLineRunner execultar algo ao iniciar a aplicação com o framework spring
@SpringBootApplication
public class SpringDataApplication  implements CommandLineRunner {

	private final CrudCargoService crudCargoService;
	private final CrudCargoPaginadoService crudCargoPaginadoService;
	private final FuncionariosService funcionariosService;
	private final FuncionarioSpecification funcionarioSpecification;
	public SpringDataApplication(FuncionarioSpecification funcionarioSpecification,CrudCargoService crudCargoService,CrudCargoPaginadoService crudCargoPaginadoService,FuncionariosService funcionariosService){
		this.crudCargoService=crudCargoService;
		this.crudCargoPaginadoService = crudCargoPaginadoService;
		this.funcionariosService =funcionariosService;
		this.funcionarioSpecification =funcionarioSpecification;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Boolean status=true;
		while (status){
			Scanner scaner=new Scanner(System.in);
			System.out.println("Seja bem vindo!!");
			System.out.println("selecionar uma opção: (1)Adiconar novos cargo, (2)Atualizar (3) buscar por nome cargo, (4) Paginação, (5) todos cargos projeções,(7) " +
					"funcionarios paginados ");

			int acao=scaner.nextInt();
			if(acao==1){
				crudCargoService.salvarCargo();
			}else if(acao==2){
				crudCargoService.atualizar(); }
			else if(acao==3){
			crudCargoService.buscarPorNome();	}
			else if(acao==4){
				crudCargoPaginadoService.buscaPaginadaCargos();
				}
			else if(acao==5){
				funcionariosService.buscarFuncionarioOrdenado();
			}
			else if(acao==6){
				crudCargoService.todosCargos();
			}
			else if(acao==7){
				funcionarioSpecification.iniciar();
			}


			else {
				status=false;
				System.out.println("Sucesso ao sair da aplicação!!");

			}

		}

	}
}
