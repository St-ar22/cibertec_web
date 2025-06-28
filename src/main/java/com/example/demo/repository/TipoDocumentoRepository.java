package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelos.TipoDocumento;

@Repository
public interface TipoDocumentoRepository extends 
	JpaRepository<TipoDocumento, Integer>{

}
