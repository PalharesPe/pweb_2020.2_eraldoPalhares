package br.com.AgroPopShopEraldo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.AgroPopShopEraldo.model.Dependente;

@Repository
public interface depRepository extends JpaRepository<Dependente , Long> {

}
