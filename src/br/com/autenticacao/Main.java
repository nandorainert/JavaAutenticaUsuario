package br.com.autenticacao;

import javax.swing.JOptionPane;

import br.com.autenticacao.controller.UsuarioController;
import br.com.autenticacao.model.Usuario;

public class Main {

	public static void main(String[] args) {

		UsuarioController controller = new UsuarioController();
		
		String funcao = JOptionPane.showInputDialog(
				"Digite a função que deseja fazer: [1] Fazer login | [2]Cadastrar | [3] Esqueci minha senha.");

		switch (funcao) {
		case "1":
			
			String email = JOptionPane.showInputDialog("Digite seu email:");
			String senha = JOptionPane.showInputDialog("Digite sua senha:");
			
			controller.autenticacao(email, senha);
			
			break;
		case "2":
			String nomeCad = JOptionPane.showInputDialog("Digite seu nome:");
			String emailCad = JOptionPane.showInputDialog("Digite seu email:");
			String senhaCad = JOptionPane.showInputDialog("Digite sua senha:");
			
			Usuario u = new Usuario();
			u.setNome(nomeCad);
			u.setEmail(emailCad);
			u.setSenha(senhaCad);
			u.setisAtivo(true);
			controller.cadastrar(u);
			break;
		case "3":
			
			break;

		}

	}

}