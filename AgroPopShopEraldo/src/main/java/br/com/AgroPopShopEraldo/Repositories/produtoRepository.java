package br.com.AgroPopShopEraldo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.AgroPopShopEraldo.produto.Produto;

@Repository
public interface produtoRepository extends JpaRepository<Produto, Long>{

	
}
