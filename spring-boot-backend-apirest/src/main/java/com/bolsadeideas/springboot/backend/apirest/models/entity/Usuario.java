package com.bolsadeideas.springboot.backend.apirest.models.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "USUARIO")
public class Usuario {



    //field used for table of database
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY,generator = "uuid" )
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID_USER")
    private String id;

    @Column(name = "NAME_U")
    private String name_U;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD_U")
    private String password_U;

    @Column(name = "CREATED")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date created;

    @Column(name = "MODIFIED")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date modified;

    @Column(name = "LAST_LOGIN")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date last_login;

    @Column(name = "TOKEN")
    private String token;

    @Column(name = "ISACTIVE")
    private Boolean isactive;

    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Phone> phones;


    //SET AND GET


    public Usuario() {
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName_U() {
        return name_U;
    }

    public void setName_U(String name_U) {
        this.name_U = name_U;
    }

    public String getPassword_U() {
        return password_U;
    }

    public void setPassword_U(String password_U) {
        this.password_U = password_U;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getIsactive() {
        return isactive;
    }

    public void setIsactive(Boolean isactive) {
        this.isactive = isactive;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }
}


