package dao;

//Importando bibliotecas.
import model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

//Criação da classe ProdutoDAO onde cria instância do persistence para operações no banco de dados. Fazendo o JPA interagir com o banco de dados. 
public class ProdutoDAO {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("produtoPU");
	
//Criação de um dos métodos para inserir um objeto criado na classe Produto e lançar ao banco de dados. 
	public void criar (Produto produto) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(produto);
		em.getTransaction().commit();
		em.close(); //fecha a interação.
	}
	
//Criação de um dos métodos CRUD para ler uma informação do banco de dados através do id do Produto. 
	public Produto ler(Long id) {
		EntityManager em = emf.createEntityManager(); //responsável pela interação com o banco de dados.
		Produto produto = em.find(Produto.class, id);
		em.close(); //fecha a interação.
		return produto; //retorna a lista de produtos. 
	}
	
//Criação de um dos métodos CRUD para puxar todas as informações presentes no banco de dados. 
	public List<Produto> listarTodos(){
		EntityManager em = emf.createEntityManager(); //responsável pela interação com o banco de dados.
		List<Produto> produtos = em.createQuery("FROM Produto", Produto.class).getResultList(); //Puxa as informações do banco de dados. 
		em.close(); //fecha a interação.
		return produtos;
	}

//Criação de um dos métodos CRUD para atualizar informações de um objeto presente no banco de dados.
	public void atualizar(Produto produto) {
		EntityManager em = emf.createEntityManager(); //responsável pela interação com o banco de dados.
		em.getTransaction().begin();
		em.merge(produto);
		em.getTransaction().commit();
		em.close(); //fecha a interação.
	}
	
//Criação de um dos métodos CRUD para excluir informações de um objeto presente no banco de dados.
	public void excluir(Long id) {
		EntityManager em = emf.createEntityManager(); //responsavel pela interação com o banco de dados.
		Produto produto = em.find(Produto.class, id);
		if (produto != null) { //Cria condição onde o produto não pode ser nulo. 
			em.getTransaction().begin();
			em.remove(produto);
			em.getTransaction().commit();
		}
		em.close(); //fecha a interação. 
	}

}
