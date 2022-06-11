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


@Data
@Entity
@Table(name = "contacto")
public class Contacto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre_completo", nullable = false, length = 45)
    private String nombreCompleto;

    //@Convert(disableConversion = true)
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    //@Convert(disableConversion = true)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    //@Convert(disableConversion = true)
    @Column(name = "update_at")
    private Instant updateAt;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(
            targetEntity = Email.class,
            cascade = CascadeType.REMOVE,
            mappedBy = "contacto"
    )
    @JsonManagedReference
    private List<Email> emails = new ArrayList<>();

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(
            targetEntity = Telefono.class,
            cascade = CascadeType.REMOVE,
            mappedBy = "contacto"
    )
    @JsonManagedReference
    private List<Telefono> telefonos = new ArrayList<>();

}