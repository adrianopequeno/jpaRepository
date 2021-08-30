package com.devsuperior.aulajparepository.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.aulajparepository.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	// Metodo que Procura salarios entre dois valores :: JPQL
	@Query("SELECT obj FROM User obj WHERE obj.salary >= :minSalary AND obj.salary <= :maxSalary")
	Page<User> searchAlary(Double minSalary, Double maxSalary, Pageable pageable);
	
	// Metodo que Procura salarios entre dois valores :: Query Methods
	Page<User> findBySalaryBetween(Double minSalary, Double maxSalary, Pageable pageable);


	// Método que Procura um funcionario pelo nome :: JPQL
	@Query("SELECT obj FROM User obj WHERE LOWER(obj.name) LIKE LOWER(CONCAT('%',:name,'%'))")
	Page<User> searchName(String name, Pageable pageable);
	
	// Método que Procura um funcionario pelo nome :: Query Method
	Page<User> findByNameContainingIgnoreCase(String name, Pageable pageable);

}
