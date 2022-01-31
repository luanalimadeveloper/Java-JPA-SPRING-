package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario2 {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager(); 
		
		/* consulta dentro de um contexto transassional -> resultado (usuario) fica no estado gerenciado (sincronizado co BD mesmo que nao chame metodo merge)*/
		em.getTransaction().begin();
		
		Usuario usuario = em.find(Usuario.class, 7l); /* consultar usuario */
		usuario.setNome("Leonardo Alterado Novamente");
		
		/* Comando de atualiza�ao no banco de dados */
		// em.merge(usuario);
		
		em.getTransaction().commit();
		

		em.close();
		emf.close();
	}

}
