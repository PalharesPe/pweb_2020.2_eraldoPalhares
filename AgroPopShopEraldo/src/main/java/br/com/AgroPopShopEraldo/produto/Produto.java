package br.com.AgroPopShopEraldo.produto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="produto")
public class Produto implements Serializable{

	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String marca;
	private long altura, largura, profundidade, peso, preco;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public long getAltura() {
		return altura;
	}
	public void setAltura(long altura) {
		this.altura = altura;
	}
	public long getLargura() {
		return largura;
	}
	public void setLargura(long largura) {
		this.largura = largura;
	}
	public long getProfundidade() {
		return profundidade;
	}
	public void setProfundidade(long profundidade) {
		this.profundidade = profundidade;
	}
	public long getPeso() {
		return peso;
	}
	public void setPeso(long peso) {
		this.peso = peso;
	}
	public long getPreco() {
		return preco;
	}
	public void setPreço(long preco) {
		this.preco = preco;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}