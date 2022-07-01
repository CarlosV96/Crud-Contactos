package com.sofka.crud.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import java.io.Serializable;
import java.time.Instant;

/**
 * Entidad Email
 *
 * @author Carlos Valencia <caliche-9696@hotmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
@Data
@Entity
@Table(name = "email")
public class Email implements Serializable {

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
    private Integer emailId;

    /**
     * Punto de enlace con la entidad contacto
     */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Contacto.class, optional = false)
    @JoinColumn(name = "contacto_id", nullable = false)
    @JsonBackReference
    private Contacto contacto;

    /**
     * Correo electronico.
     */
    @Column(name = "email", nullable = false, length = 45)
    private String email;

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

}