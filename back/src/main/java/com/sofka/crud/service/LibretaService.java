package com.sofka.crud.service;

import com.sofka.crud.domain.Contacto;
import com.sofka.crud.domain.Email;
import com.sofka.crud.domain.Telefono;
import com.sofka.crud.repository.ContactoRepository;
import com.sofka.crud.repository.EmailRepository;
import com.sofka.crud.repository.TelefonoRepository;
import com.sofka.crud.service.interfaces.ILibreta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;

@Service
public class LibretaService implements ILibreta {

    @Autowired
    private ContactoRepository contactoRepository;

    @Autowired
    private TelefonoRepository telefonoRepository;

    @Autowired
    private EmailRepository emailRepository;

    /**
     * Devuelve una lista con todos contactos del sistema
     */
    @Override
    @Transactional(readOnly = true)
    public List<Contacto> getList() {
        return contactoRepository.findAll();
    }

    /*
    /**
     * Devuelve lista de Contactos con todos contactos del sistema ordenados por el campo indicado
     * ya sea ascendente o descendente
     *
     * @param field campo por el cual ordenar
     * @param order método de ordenado ASC o DESC
     * @return Lista de contactos
     *
    @Override
    @Transactional(readOnly = true)
    public List<Contacto> getList(String field, Sort.Direction order) {
        return contactoRepository.findAll(Sort.by(order, field));
    }

    /**
     * Busca un dato por el nombre en un contacto
     *
     * @param dataToSearch Dato a buscar
     * @return Lita de contactos
     *
    @Override
    @Transactional(readOnly = true)
    public List<Contacto> buscarContacto(String dataToSearch) {
        var contacto1 = contactoRepository.findByNombreStartingWith(dataToSearch);
        var contacto2 = contactoRepository.findByNombreContains(dataToSearch);
        var contacto3 = contactoRepository.findByNombreEndingWith(dataToSearch);
        var answer = new HashSet<Contacto>();
        answer.addAll(contacto1);
        answer.addAll(contacto2);
        answer.addAll(contacto3);
        return answer.stream().toList();
    }
    */

    /**
     * Crea un contacto
     *
     * @param contacto Objeto del contacto a crear
     * @return Objeto del contacto creado
     */
    @Override
    @Transactional
    public Contacto createContacto(Contacto contacto) {
        contacto.setCreatedAt(Instant.now());
        return contactoRepository.save(contacto);
    }

    /**
     * Crea un teléfono en el sistema a nombre de un contacto
     *
     * @param telefono Objeto del teléfono a crear
     * @return Objeto del teléfono creado
     */
    @Override
    @Transactional
    public Telefono createTelefono(Telefono telefono) {
        telefono.setCreatedAt(Instant.now());
        return telefonoRepository.save(telefono);
    }

    /**
     * Crea un email en el sistema a nombre de un contacto
     *
     * @param email Objeto del email a crear
     * @return Objeto del email creado
     */
    @Override
    @Transactional
    public Email createEmail(Email email) {
        email.setCreatedAt(Instant.now());
        return emailRepository.save(email);
    }

    /**
     * Actualiza una tupla completa de un contacto
     *
     * @param id Identificador del contacto a actualizar
     * @param contacto Objeto del contacto a actualizar
     * @return Objeto del contacto actualizado
     */
    @Override
    @Transactional
    public Contacto updateContacto(Integer id, Contacto contacto) {
        contacto.setId(id);
        contacto.setUpdateAt(Instant.now());
        return contactoRepository.save(contacto);
    }



    /**
     * Actualiza el nombre de un contacto basado en su identificador
     *
     * @param id Identificador del contacto a actualizar
     * @param contacto Objeto del contacto a actualizar
     * @return Objeto del contacto actualizado
     */
    @Override
    @Transactional
    public Contacto updateNombre(Integer id, Contacto contacto) {
        contacto.setId(id);
        contacto.setUpdateAt(Instant.now());
        contactoRepository.updateNombre(id, contacto.getNombreCompleto());
        return contacto;
    }

    /**
     * Actualiza la fecha de nacimiento de un contacto basado en su identificador
     *
     * @param id Identificador del contacto a actualizar
     * @param contacto Objeto del contacto a actualizar
     * @return Objeto del contacto actualizado
     */
    @Override
    @Transactional
    public Contacto updateFechaNacimiento(Integer id, Contacto contacto) {
        contacto.setId(id);
        contacto.setUpdateAt(Instant.now());
        contactoRepository.updateFechaNacimiento(id, contacto.getFechaNacimiento());
        return contacto;
    }

    /**
     * Actualiza la tupla completa de un teléfono en el sistema basado en su identificador
     *
     * @param id Identificador del teléfono a actualizar
     * @param telefono Objeto del teléfono a actualizar
     * @return Objeto del teléfono actualizado
     */
    @Override
    @Transactional
    public Telefono updateTelefono(Integer id, Telefono telefono) {
        telefono.setTelId(id);
        telefono.setUpdateAt(Instant.now());
        return telefonoRepository.save(telefono);
    }

    /**
     * Actualiza la tupla completa de un email en el sistema basado en su identificador
     *
     * @param id Identificador del teléfono a actualizar
     * @param email Objeto del teléfono a actualizar
     * @return Objeto del email actualizado
     */
    @Override
    @Transactional
    public Email updateEmail(Integer id, Email email) {
        email.setEmailId(id);
        email.setUpdateAt(Instant.now());
        emailRepository.save(email);
        return email;
    }



    /**
     * Borra un contacto del sistema basado en su identificador
     *
     * @param id Identificación del contacto a borrar
     * @return Objeto del contacto borrado
     */
    @Override
    @Transactional
    public Contacto deleteContacto(Integer id) {
        var contacto = contactoRepository.findById(id);
        if (contacto.isPresent()) {
            contactoRepository.delete(contacto.get());
            return contacto.get();
        } else {
            return null;
        }
    }

    /**
     * Borra un teléfono del sistema basado en su identificador
     *
     * @param id Identificación del teléfono a borrar
     * @return Objeto del teléfono borrado
     */
    @Override
    @Transactional
    public Telefono deleteTelefono(Integer id) {
        var telefono = telefonoRepository.findById(id);
        if (telefono.isPresent()) {
            telefonoRepository.delete(telefono.get());
            return telefono.get();
        } else {
            return null;
        }
    }

    /**
     * Borra un email del sistema basado en su identificador
     *
     * @param id Identificación del email a borrar
     * @return Objeto del email borrado
     */
    @Override
    @Transactional
    public Email deleteEmail(Integer id) {
        var email = emailRepository.findById(id);
        if (email.isPresent()) {
            emailRepository.delete(email.get());
            return email.get();
        } else {
            return null;
        }
    }
}

    /*

     ESTE CAMPO NO SE USA YA QUE AL MODIFICAR LA TUPLA DE TELEFONO
     SE MODIFICA LO QUE LLEVA EN SU INTERIOR QUE SOLO ES EL NUMERO TELEFÓNICO

     *
     * Actualiza solamente el teléfono de un contacto a partir del ID de la tupla del teléfono
     *
     * @param id Identificador del teléfono a actualizar
     * @param telefono Objeto del teléfono a actualizar
     * @return Objeto del teléfono actualizado
     *
    @Override
    @Transactional
    public Telefono updateOnlyTelefono(Integer id, Telefono telefono) {
        telefono.setTelId(id);
        telefono.setUpdateAt(Instant.now());
        telefonoRepository.updateTelefono(id, telefono.getTelefono());
        return telefono;
    }

-------------------------------------------------------------------------------------------
     ESTE CAMPO IGUAL QUE EL TELEFONO

     *
     * Actualiza solamente el email de un contacto a partir del ID de la tupla del email
     *
     * @param id Identificador del teléfono a actualizar
     * @param email Objeto del email a actualizar
     * @return Objeto del email actualizado
     *
    @Override
    @Transactional
    public Email updateOnlyEmail(Integer id, Email email) {
        email.setEmailId(id);
        email.setUpdateAt(Instant.now());
        emailRepository.updateEmail(id, email.getEmail());
        return email;
    }
    */
