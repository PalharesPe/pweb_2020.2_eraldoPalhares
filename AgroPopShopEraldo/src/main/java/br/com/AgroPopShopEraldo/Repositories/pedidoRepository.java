package br.com.AgroPopShopEraldo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.AgroPopShopEraldo.pedido.PedidoVenda;

public interface pedidoRepository extends JpaRepository<PedidoVenda, Long> {

}
