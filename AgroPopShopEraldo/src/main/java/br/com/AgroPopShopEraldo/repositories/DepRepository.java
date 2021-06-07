package br.com.AgroPopShopEraldo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.AgroPopShopEraldo.model.Dependente;

@Repository
public interface DepRepository extends JpaRepository<Dependente , Long> {

}
