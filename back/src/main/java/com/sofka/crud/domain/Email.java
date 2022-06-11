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
//import javax.persistence.Convert;
import java.io.Serializable;
import java.time.Instant;

@Data
@Entity
@Table(name = "email")
public class Email implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "email_id", nullable = false)
    private Integer emailId;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Contacto.class, optional = false)
    @JoinColumn(name = "contacto_id", nullable = false)
    @JsonBackReference
    private Contacto contacto;

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    //@Convert(disableConversion = true)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    //@Convert(disableConversion = true)
    @Column(name = "update_at")
    private Instant updateAt;

}