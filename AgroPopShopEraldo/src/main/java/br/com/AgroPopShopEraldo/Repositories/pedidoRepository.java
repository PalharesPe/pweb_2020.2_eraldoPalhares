package br.com.AgroPopShopEraldo.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.AgroPopShopEraldo.pedido.Pedido;

public interface pedidoRepository extends JpaRepository<Pedido, Long> {

	List<Pedido> findByIdPedido(long id);

}
