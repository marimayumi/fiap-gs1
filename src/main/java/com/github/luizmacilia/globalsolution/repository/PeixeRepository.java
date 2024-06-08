package com.github.luizmacilia.globalsolution.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.luizmacilia.globalsolution.model.Peixe;

@Repository
public interface PeixeRepository extends JpaRepository<Peixe, Long>{
	
	
	
}
