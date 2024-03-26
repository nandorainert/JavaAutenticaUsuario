package br.com.autenticacao;

import br.com.autenticacao.controller.UsuarioController;
import br.com.autenticacao.model.Usuario;

public class Main {

	public static void main(String[] args) {

		Usuario usuario3 = new Usuario();
		
		usuario3.setNome("Isabel Zimmermann Rainert");
		usuario3.setEmail("IsabelZRainert@gmail.com");
		usuario3.setSenha("Deco");
		usuario3.setisAtivo(true);
		
		UsuarioController controller = new UsuarioController();
		controller.cadastrar(usuario3);
		
	}

}
