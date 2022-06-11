package com.sofka.crud.repository;

import com.sofka.crud.domain.Contacto;
import com.sofka.crud.domain.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmailRepository extends JpaRepository<Email, Integer> {

    /**
     * Actualiza solamente el email basado en el identificador de la tupla
     *
     * @param id
     * @param email
     */
    @Modifying
    @Query(value = "UPDATE Email email " +
            "SET email.email = :email, email.updateAt = " +
            "CURRENT_TIMESTAMP where email.emailId = :id")
    public void updateEmail(@Param(value = "id") Integer id, @Param(value = "email") String email);

    /**
     * Selecciona los emails de un contacto en específico
     *
     * @param contacto Objeto del contacto
     * @return Listado de emails encontrados
     */
    @Query(value = "SELECT email " +
            "FROM Email email " +
            "WHERE email.contacto = :contacto")
    public List<Email> findAllByContacto(@Param(value = "contacto") Contacto contacto);
}