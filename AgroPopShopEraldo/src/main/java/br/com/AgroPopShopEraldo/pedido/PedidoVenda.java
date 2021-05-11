package br.com.AgroPopShopEraldo.pedido;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "pedido")

public class PedidoVenda implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@DateTimeFormat(pattern = "dd-MMM-YYYY")
	private LocalDate dataPedido = LocalDate.now();

	private double totalProduto, totalPedido;
	private String formadePagamento, Cartao, valorPago;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public LocalDate getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}
	
	public double getTotalPedido() {
		return totalPedido;
	}
	public void setTotalPedido(double totalPedido) {
		this.totalPedido = totalPedido;
	}
	public String getFormaDePagamento() {
		return formadePagamento;
	}
	public void setFormaDePagamento(String formadePagamento) {
		this.formadePagamento = formadePagamento;
	}
	public String getCartao() {
		return Cartao;
	}
	public void setCartao(String Cartao) {
		this.Cartao = Cartao;
	}
	public String getValorPago() {
		return valorPago;
	}
	public void setValorPago(String valorPago) {
		this.valorPago = valorPago;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public double getTotalProduto() {
		return totalProduto;
	}
	public void setTotalProduto(double totalProduto) {
		this.totalProduto = totalProduto;
	}
	
}