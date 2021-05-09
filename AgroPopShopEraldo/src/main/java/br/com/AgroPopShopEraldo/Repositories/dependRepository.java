package br.com.AgroPopShopEraldo.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.AgroPopShopEraldo.model.Dependente;

@Repository
public interface dependRepository extends JpaRepository<Dependente , Long> {
	List<Dependente> findByIdPrincipal (long id);
}
