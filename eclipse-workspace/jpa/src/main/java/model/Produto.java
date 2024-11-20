package model;

//Importando bibliotecas.
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //Identifica classe onde representa uma tabela do banco de dados. Fazendo o mapeamento da classe para uma tabela no banco de dados.
public class Produto {
	@Id //Identificando chave primária da entidade.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String nome; //Criação das colunas adicionais. 
	private Double preco;
	
	//Métodos Getters e setter para acessar e alterar atributos privados (encapsulamento).
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Double getPreco() {
		return preco;
	}
	
	public void setPreco(Double preco) {
		this.preco = preco;
	}
}
