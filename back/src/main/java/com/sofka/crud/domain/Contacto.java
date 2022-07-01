package com.sofka.crud.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.Column;
//import javax.persistence.Convert;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidad contacto
 *
 * @author Carlos Valencia <caliche-9696@hotmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
@Data
@Entity
@Table(name = "contacto")
public class Contacto implements Serializable {

    /**
     * Variable usada para manejar el tema del identificador de la tupla (consecutivo)
     */
    private static final long serialVersionUID = 1L;

    /**
     * Identificador de la tupla
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    /**
     * Nombre del contacto
     */
    @Column(name = "nombre_completo", nullable = false, length = 45)
    private String nombreCompleto;

    /**
     * Fecha de nacimiento del contacto
     */
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    /**
     * Fecha y hora de la creación de la tupla
     */
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    /**
     * Fecha y hora de la última actualización
     */
    @Column(name = "update_at")
    private Instant updateAt;

    /**
     * Punto de enlace entre el contacto y la tupla email.
     */
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(
            targetEntity = Email.class,
            cascade = CascadeType.REMOVE,
            mappedBy = "contacto"
    )
    @JsonManagedReference
    private List<Email> emails = new ArrayList<>();

    /**
     * Punto de enlace entre el contacto y la tupla teléfono.
     */
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(
            targetEntity = Telefono.class,
            cascade = CascadeType.REMOVE,
            mappedBy = "contacto"
    )
    @JsonManagedReference
    private List<Telefono> telefonos = new ArrayList<>();

}