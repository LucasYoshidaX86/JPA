package Main;

//Importando bibliotecas.
import dao.ProdutoDAO;
import model.Produto;

import java.util.Scanner;

//Criação da classe Main para receber a entrada do usuário e interagir com a classe ProdutoDAO com as operações CRUD.
public class Main {
	public static void main(String[] args) {
		ProdutoDAO produtoDAO = new ProdutoDAO(); //Cria instância da classe ProdutoDAO.
		Scanner scanner = new Scanner(System.in); //Ativa o scanner para receber a entrada do usuário.
		
		String continuar = "sim";
		while (continuar.equalsIgnoreCase("sim")) { //Cria loop infinito While para fazer o sistema rodar e permitir que vários produtos possam ser armazenados, puxados e atualizados no banco de dados.
			
			Produto produto = new Produto(); //Instância um novo produto.
			System.out.print("Digite o nome do produto: "); //Exibe a mensagem ao usuário.
			produto.setNome(scanner.nextLine()); //Recebe a informação e armazena.
			
			System.out.print("Digite o preço do produto: "); //Exibe a mensagem ao usuário.
			produto.setPreco(scanner.nextDouble()); //Recebe a informação e armazena.
			scanner.nextLine(); //Limpa o buffer.
			
			//Chama a classe ProdutoDAO para criar o novo produto e armazenar no banco de dados.
			produtoDAO.criar(produto);
			
			System.out.print("Deseja adicionar outro produto? (sim/não): "); //Faz uma pergunta ao usuário.
			continuar = scanner.nextLine(); //Recebe a resposta do usuário e armazena.
		}
		
		//Após sair do loop While, caso o usuário digite "não", exibe a lista de produtos armazenados no banco de dados.
		System.out.println("\nLista de produtos no banco de dados:");
		produtoDAO.listarTodos().forEach(p -> System.out.println(p.getNome() + " - " + p.getPreco()));
		
		scanner.close(); //Fecha a função Scanner.
	}
}
