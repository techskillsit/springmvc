package com.springhibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springhibernate.model.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Long>{

}
