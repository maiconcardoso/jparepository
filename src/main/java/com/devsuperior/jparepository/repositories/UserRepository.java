package com.devsuperior.jparepository.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.jparepository.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	@Query("SELECT obj FROM User obj WHERE obj.salary >= :minSalary AND obj.salary <= :maxSalary")
	Page<User> findBySalaryBetween(Double minSalary, Double maxSalary, Pageable pageable);

	@Query("SELECT obj from User obj WHERE LOWER(obj.name) like LOWER(CONCAT('%',:name, '%')) ")
	Page<User> findByName(String name, Pageable pageable);

}
