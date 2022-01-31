package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario3 {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager(); 
		
		
		em.getTransaction().begin();
		
		Usuario usuario = em.find(Usuario.class, 7l); 
		em.detach(usuario); /* DESASSOCIAR */ /* Tirar objeto do estado gerenciavel. Salva apenas se tiver o merge*/
		usuario.setNome("Leonardo");

		/* Comando de atualizašao no banco de dados */
		// em.merge(usuario);
		
		em.getTransaction().commit();
		

		em.close();
		emf.close();
		
	}

}
