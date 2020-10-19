package com.bolsadeideas.springboot.backend.apirest.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Phone;


@Repository
public interface PhonesRepository extends JpaRepository<Phone,String> {

}
