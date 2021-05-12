package br.com.AgroPopShopEraldo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.AgroPopShopEraldo.pedido.Venda;

public interface pedidoRepository extends JpaRepository<Venda, Long> {

}
