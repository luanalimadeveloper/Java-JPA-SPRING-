package teste.basico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.basico.Usuario;

public class ObterUsuarios {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager(); 
		
		/* java persistence query language */
		String jpql = "select u from Usuario u"; /* traz todos os atributos */
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class); /* Consulta no banco de dados - passa a consulta jpql e a classe que eu quero que ele retorne */
		query.setMaxResults(5); /* quantos resultados quero ter */
		
		List<Usuario> usuarios = query.getResultList();
		
		/*
		List<Usuario> usuarios = em
				.createQuery("select u from Usuario u", Usuario.class)
				.setMaxResults(5)
				.getResultList();
		*/
		
		for(Usuario usuario: usuarios) {
			System.out.println("ID: " + usuario.getId()
					+ " E-mail: " + usuario.getEmail());
		}
		
		
		em.close();
		emf.close();
	}
	

}
