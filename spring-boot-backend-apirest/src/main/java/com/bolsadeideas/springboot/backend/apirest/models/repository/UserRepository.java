package com.bolsadeideas.springboot.backend.apirest.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario,String>{

	Usuario findByEmail(String email);
}
