package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class NovoUsuario {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager(); 
		
		Usuario novoUsuario = new Usuario("maria", "maria@lanche.com.br");
		
		
		/* Inserir novo usuario */ 
		em.getTransaction().begin();
		em.persist(novoUsuario); /* gera um insert */
		em.getTransaction().commit();
		
		System.out.println("O Id gerado foi: " + novoUsuario.getId());
		
		
		em.close();
		emf.close();
	}

}
