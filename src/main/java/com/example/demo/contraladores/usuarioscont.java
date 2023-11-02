package com.example.demo.contraladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.documentos.usuarios;
import com.example.demo.repositorio.usuariosrepo;


@RestController
@RequestMapping("/Usuarios")
public class usuarioscont {
	
	
	@Autowired
	private usuariosrepo usuariosRepo;
	
	@PostMapping
	public ResponseEntity<?> saveUsuario(@RequestBody usuarios usuario){
		try {
			usuarios UserSave = usuariosRepo.save (usuario);
			return new ResponseEntity<usuarios>(UserSave, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping
	public ResponseEntity<?> findAllusuarios(){
		try {
			List<usuarios> usuarios=usuariosRepo.findAll();
			return new ResponseEntity<List<usuarios>>(usuarios, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@PutMapping
	public ResponseEntity<?> updateUsuario(@RequestBody usuarios usuario){
		try {
			usuarios UserSave = usuariosRepo.save (usuario);
			return new ResponseEntity<usuarios>(UserSave, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> deleteUsuario(@PathVariable("id") Integer id){
		try {
			usuariosRepo.deleteById(id);
			return new ResponseEntity<String>("fue eliminado", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
