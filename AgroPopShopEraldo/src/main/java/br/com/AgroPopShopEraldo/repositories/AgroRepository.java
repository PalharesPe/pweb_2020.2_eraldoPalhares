package br.com.AgroPopShopEraldo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.AgroPopShopEraldo.model.Cliente;

@Repository
public interface AgroRepository extends JpaRepository<Cliente, Long>{

}