package com.example.demo.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.documentos.usuarios;



public interface usuariosrepo extends MongoRepository<usuarios, Integer> {

}
