package com.sofka.crud.repository;

import com.sofka.crud.domain.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 * Repositorio para la entidad Email
 *
 * @author Carlos Valencia <caliche-9696@hotmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
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

}