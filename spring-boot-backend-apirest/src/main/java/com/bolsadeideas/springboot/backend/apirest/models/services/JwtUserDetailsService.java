package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Usuario;
import com.bolsadeideas.springboot.backend.apirest.models.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService{
	
	private final static Logger LOGGER = Logger.getLogger(JwtUserDetailsService.class.getName());

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    	
    	LOGGER.info("Find the user in the DB");
    	
    	Usuario user =  userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        
        LOGGER.info("User obtained");
        
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword_U(),
                new ArrayList<>());
    }

	
}
