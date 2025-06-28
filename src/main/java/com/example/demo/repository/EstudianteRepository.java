package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelos.Estudiante;

@Repository
public interface EstudianteRepository extends 
JpaRepository<Estudiante, Long>{

}
