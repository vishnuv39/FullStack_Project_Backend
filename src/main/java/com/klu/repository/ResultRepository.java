package com.klu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.klu.model.Result;

public interface ResultRepository extends JpaRepository<Result, Integer> {
	
	
    List<Result> findByEmail(String email);
    
}