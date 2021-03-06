package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.hibernate.query.criteria.internal.predicate.IsEmptyPredicate;

public class DAO<E>{

	private static EntityManagerFactory emf;
	private EntityManager em; 
	private Class<E> classe;
	
	static {
		try {
			emf = Persistence.createEntityManagerFactory("exercicios-jpa");
			
		} catch (Exception e) {
			// logar -> log4j
		}
	}
	
	public DAO() {	
		this(null); // Construtur this passando a classe nulo
	}
	
	public DAO(Class<E> classe) {
		this.classe = classe;
		em = emf.createEntityManager();
	}
	
	/* abrir transa?ao */
	public DAO<E> abrirT() {
		em.getTransaction().begin();
		return this;
	}
	
	public DAO<E> fecharT() {
		em.getTransaction().commit();
		return this;
	}
	
	public DAO<E> incluir(E entidade) {
		em.persist(entidade);
		return this;
	}
	
	/* Vai fazer abertura e fechamento da transa??o */
	public DAO<E> incluirAtomico(E entidade) {
		return this.abrirT().incluir(entidade).fecharT();
	}
	
	public E obterPorId(Object id) {
		return em.find(classe, id);
	}
	
	public List<E> obterTodos(){
		return this.obterTodos(10, 0);
	}
	
	public List<E> obterTodos(int qtde, int deslocamento) {
		if(classe == null) {
			throw new UnsupportedOperationException("Classe nula. ");
		}
		
		/* TODA CONSULTA EM JPQL PRECISA DE TER UM ALIAS*/
		String jpql = "select e from " + classe.getName() + " e";  /* consulta*/ 
		TypedQuery<E> query = em.createQuery(jpql, classe);
		query.setMaxResults(qtde);
		query.setFirstResult(deslocamento);
		return query.getResultList();
	}
	
	/* Object...  : Como se fosse um array */
	public List<E> consultar(String moneConsulta, Object... params ){
		TypedQuery<E> query = em.createNamedQuery(moneConsulta, classe);
		
		for (int i = 0; i < params.length; i+= 2) {
			query.setParameter(params[i].toString(), params[i + 1]);
		}
		
		return query.getResultList();
	}
	
	public E consultarUm(String nomeConsulta, Object... params){
		List<E> lista = consultar(nomeConsulta, params);
		return lista.isEmpty() ? null : lista.get(0);
	}
	
	public void fechar() {
		em.close();
	}
	
	
	/*
	public DAO<E> teste(){
		return this;
	}
	
	public static void main(String[] args) {
		new DAO<Produto>().teste().teste().teste();
	}
	*/
	
	
}
