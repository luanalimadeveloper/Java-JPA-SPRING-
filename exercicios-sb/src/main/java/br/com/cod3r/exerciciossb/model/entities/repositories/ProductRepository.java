package br.com.cod3r.exerciciossb.model.entities.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.cod3r.exerciciossb.model.entities.Produto;

/* ProductRepository  - responsavel por abstrair os dados*/
public interface ProductRepository 
	extends PagingAndSortingRepository<Produto, Integer>{

}
