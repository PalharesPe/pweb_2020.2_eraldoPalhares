package br.com.AgroPopShopEraldo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.AgroPopShopEraldo.pedido.Pedido;
@Repository
public interface VendaRepository extends JpaRepository<Pedido, Long>{

}
