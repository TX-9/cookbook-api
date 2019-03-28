package com.tx9.cookbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tx9.cookbook.model.Cookbook;

@Repository
public interface CookbookRepository extends JpaRepository<Cookbook, Long>{

}
