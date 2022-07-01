package com.sofka.crud.repository;

import com.sofka.crud.domain.Telefono;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Repositorio para la entidad Telefono
 *
 * @author Carlos Valencia <caliche-9696@hotmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public interface TelefonoRepository extends JpaRepository<Telefono, Integer> {

    /**
     * Actualiza solamente el teléfono basado en el identificador de la tupla
     *
     * @param id
     * @param telefono
     */
    @Modifying
    @Query(value = "UPDATE Telefono tel " +
            "SET tel.telefono = :telefono, " +
            "tel.updateAt = CURRENT_TIMESTAMP " +
            "WHERE tel.telId = :id")
    public void updateTelefono(@Param(value = "id") Integer id, @Param(value = "telefono") String telefono);

}