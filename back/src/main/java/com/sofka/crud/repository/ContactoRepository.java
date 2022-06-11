package com.sofka.crud.repository;

import com.sofka.crud.domain.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

/**
 * Repositorio para la entidad Contacto
 *
 * @author Carlos Valencia <caliche-9696@hotmail.com>
 * @version 1.0.0 2022-06-06
 * @since 1.0.0
 */
public interface ContactoRepository extends JpaRepository<Contacto, Integer> {
/*
    /**
     * Busca los contactos que empiezan por nombre
     *
     * @param data Dato a buscar
     * @return Listado de contactos encontrados
     *
    @Query(value = "SELECT cnt " +
            "FROM Contacto cnt " +
            "WHERE (cnt.nombreCompleto LIKE :data%) " +
            "ORDER BY cnt.nombreCompleto ASC")
    public List<Contacto> findByNombreStartingWith(@Param("data") String data);

    /**
     * Busca los contactos que contienen X dato por nombre
     *
     * @param data Dato a buscar
     * @return Listado de contactos encontrados
     *
    @Query(value = "SELECT cnt " +
            "FROM Contacto cnt " +
            "WHERE cnt.nombreCompleto LIKE %:data%" +
            "ORDER BY cnt.nombreCompleto ASC")
    public List<Contacto> findByNombreContains(@Param("data") String data);

    /**
     * Busca los contactos que finalizan por X dato por nombre
     *
     * @param data Dato a buscar
     * @return Listado de contactos encontrados
     *
    @Query(value = "SELECT cnt " +
            "FROM Contacto cnt " +
            "WHERE cnt.nombreCompleto LIKE %:data " +
            "ORDER BY cnt.nombreCompleto ASC")
    public List<Contacto> findByNombreEndingWith(@Param("data") String data);
*/
    /**
     * Actualiza el nombre de un contacto basado en su identificador
     *
     * @param id Identificador del contacto
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
     * @param id Identificador del contacto
     * @param fechaNacimiento Nueva fecha de nacimiento del contacto
     */
    @Modifying
    @Query(value = "UPDATE Contacto cnt " +
            "SET cnt.fechaNacimiento = :fechaNacimiento, " +
            "cnt.updateAt = CURRENT_TIMESTAMP " +
            "WHERE cnt.id = :id")
    public void updateFechaNacimiento(@Param(value = "id") Integer id, @Param(value = "fechaNacimiento") LocalDate fechaNacimiento);

}

/* Me ocurrió un error al dejar la tabla de contacto sin renombrar como "cnt"
   Así que toca dejarla tabla renombrada como "cnt.---" para que no arroje errores.

   Otro error fue que no puse el  @Transactional en el método que llama estas consultas
   de modificacion*/