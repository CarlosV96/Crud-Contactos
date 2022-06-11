package com.sofka.crud.repository;

import com.sofka.crud.domain.Contacto;
import com.sofka.crud.domain.Telefono;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

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

    /**
     * Selecciona los teléfonos de un contacto en específico
     *
     * @param contacto Objeto del contacto
     * @return Listado de teléfonos encontrados
     */
    @Query(value = "SELECT tel " +
            "FROM Telefono tel " +
            "WHERE tel.contacto = :contacto")
    public List<Telefono> findAllByContacto(@Param(value = "contacto") Contacto contacto);
}