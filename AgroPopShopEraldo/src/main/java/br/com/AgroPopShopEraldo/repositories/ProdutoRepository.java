package br.com.AgroPopShopEraldo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.AgroPopShopEraldo.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
