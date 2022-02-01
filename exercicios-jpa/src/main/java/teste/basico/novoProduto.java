package teste.basico;

import infra.DAO;
import modelo.basico.Produto;

public class novoProduto {
	
	public static void main(String[] args) {

		Produto produto = new Produto("Monitor", 789.98);
		
		/*
		DAO<Produto> dao = new DAO<>(Produto.class);
		dao.abrirT().incluir(produto).fecharT().fechar();
		*/
		
		DAO<Produto> dao = new DAO<>(Produto.class);
		dao.incluirAtomico(produto).fechar();
		
		System.out.println("Id do produto: " + produto.getId());
		
		
	}

}
