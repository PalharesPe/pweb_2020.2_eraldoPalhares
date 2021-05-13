package br.com.AgroPopShopEraldo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.AgroPopShopEraldo.pedido.Pedido;
@Repository
public interface vendaRepository extends JpaRepository<Pedido, Long>{

}
