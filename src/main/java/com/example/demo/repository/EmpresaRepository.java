package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelos.Empresa;

@Repository
public interface EmpresaRepository extends 
	JpaRepository<Empresa, Long>{

}
