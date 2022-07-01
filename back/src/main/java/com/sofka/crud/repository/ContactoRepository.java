package com.sofka.crud.repository;

import com.sofka.crud.domain.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

/**
 * Repositorio para la entidad Contacto
 *
 * @author Carlos Valencia <caliche-9696@hotmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public interface ContactoRepository extends JpaRepository<Contacto, Integer> {

    /**
     * Actualiza el nombre de un contacto basado en su identificador
     *
     * @param id             Identificador del contacto
     * @param nombreCompleto Nuevo nombre del contacto
     */
    @Modifying
    @Query(value = "UPDATE Contacto cnt " +
            "SET cnt.nombreCompleto = :nombreCompleto, " +
            "cnt.updateAt = CURRENT_TIMESTAMP " +
            "WHERE cnt.id = :id")
    public void updateNombre(@Param(value = "id") Integer id, @Param(value = "nombreCompleto") String nombreCompleto);

    /**
     * Actualiza la fecha de nacimiento de un contacto basado en su identificador
     *
     * @param id              Identificador del contacto
     * @param fechaNacimiento Nueva fecha de nacimiento del contacto
     */
    @Modifying
    @Query(value = "UPDATE Contacto cnt " +
            "SET cnt.fechaNacimiento = :fechaNacimiento, " +
            "cnt.updateAt = CURRENT_TIMESTAMP " +
            "WHERE cnt.id = :id")
    public void updateFechaNacimiento(@Param(value = "id") Integer id, @Param(value = "fechaNacimiento") LocalDate fechaNacimiento);

}
