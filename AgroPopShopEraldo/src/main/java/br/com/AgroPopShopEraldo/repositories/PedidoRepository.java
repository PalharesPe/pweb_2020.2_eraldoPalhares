package br.com.AgroPopShopEraldo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.AgroPopShopEraldo.pedido.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	List<Pedido> findByIdPedido(long id);

}
