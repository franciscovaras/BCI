package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Phone;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Usuario;

public interface IUserService {
	
	Optional<Usuario> insertUser(Usuario user, Map<String, String> headers);
	
	Boolean validateEmail(String mail);
	
	Boolean validatePassword(String password);
	
	Boolean emailExists(String mail);
	
	
}
