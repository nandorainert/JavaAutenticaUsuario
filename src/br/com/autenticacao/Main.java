package br.com.autenticacao;

import java.util.Scanner;

import br.com.autenticacao.controller.UsuarioController;
import br.com.autenticacao.model.Usuario;

public class Main {

	public static void main(String[] args) {

//		Usuario usuario3 = new Usuario();
//		
//		usuario3.setNome("Isabel Zimmermann Rainert");
//		usuario3.setEmail("IsabelZRainert@gmail.com");
//		usuario3.setSenha("Deco");
//		usuario3.setisAtivo(true);
//		
//		UsuarioController controller = new UsuarioController();
//		controller.cadastrar(usuario3);
		
		Scanner scan = new Scanner(System.in);

		UsuarioController controller = new UsuarioController();
		
		int opcao = 100;
		
		do {
			System.out.println("|------------------------------------|");
			System.out.println("|--------[1] Listar usuários.--------|");
			System.out.println("|-----[2] Listar usuários p/ id.-----|");
			System.out.println("|-------[3] Cadastrar usuário.-------|");
			System.out.println("|--------[4] Alterar usuário.--------|");
			System.out.println("|--------[5] Excluir usuário.--------|");
			System.out.println("|------------[0] Encerrar.-----------|");
			System.out.println("|------------------------------------|");
			
			opcao = scan.nextInt();
			
			switch(opcao) {
			case 1:
				System.out.println("Vá pa merda");
				break;
			case 2:
				System.out.println("Vá pa merda");

				break;
			case 3:
				System.out.println("Vá pa merda");

				break;
			case 4:
				System.out.println("Vá pa merda");

				break;
			case 5:
				System.out.println("Vá pa merda");

				break;
			case 0:
				System.out.println("Vá pa merda");

				break;
			}
		}while(opcao !=0);
		
		
	}

}
