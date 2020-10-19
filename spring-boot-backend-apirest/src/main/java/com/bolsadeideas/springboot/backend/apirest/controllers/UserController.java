package com.bolsadeideas.springboot.backend.apirest.controllers;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Usuario;
import com.bolsadeideas.springboot.backend.apirest.models.services.IUserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/usuario")
public class UserController {
	
private final static Logger LOGGER = Logger.getLogger(UserController.class.getName());
	
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Crear Usuario", notes = "Servicio Creado para registrar Usuario")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Usuario Creado Exitosamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
	public ResponseEntity<Map<String, Object>> registroUsuario(@RequestBody Usuario user, @RequestHeader Map<String, String> headers) {
		
		 LOGGER.info("Obtained the request from client");
		 Optional<Usuario> userFinal = userService.insertUser(user, headers);
		 Map<String, Object> finalResponse = new LinkedHashMap<>();
		 finalResponse.put("mensaje",userFinal);
		 LOGGER.info("Return finalResponse");
		 return new ResponseEntity<>(finalResponse, HttpStatus.OK);
	}

}
