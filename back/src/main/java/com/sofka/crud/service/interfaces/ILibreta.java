package com.sofka.crud.service.interfaces;

import com.sofka.crud.domain.Contacto;
import com.sofka.crud.domain.Email;
import com.sofka.crud.domain.Telefono;

import java.util.List;

/**
 * Interfaz para el servicio de la libreta
 *
 * @author Carlos Valencia <caliche-9696@hotmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public interface ILibreta {

    /**
     * Devuelve una lista de Contactos con todos contactos del sistema
     */
    public List<Contacto> getList();

    /**
     * Crea un contacto
     *
     * @param contacto Objeto del contacto a crear
     */
    public Contacto createContacto(Contacto contacto);

    /**
     * Crea un teléfono en el sistema a nombre de un contacto
     *
     * @param telefono Objeto del teléfono a crear
     */
    public Telefono createTelefono(Telefono telefono);

    /**
     * Crea un email en el sistema a nombre de un contacto
     *
     * @param email Objeto del email a crear
     */
    public Email createEmail(Email email);

    /**
     * Actualiza una tupla completa de un contacto
     *
     * @param id       Identificador del contacto a actualizar
     * @param contacto Objeto del contacto a actualizar
     */
    Contacto updateContacto(Integer id, Contacto contacto);

    /**
     * Actualiza el nombre de un contacto basado en su identificador
     *
     * @param id       Identificador del contacto a actualizar
     * @param contacto Objeto del contacto a actualizar
     */
    public Contacto updateNombre(Integer id, Contacto contacto);

    /**
     * Actualiza la fecha de nacimiento de un contacto basado en su identificador
     *
     * @param id       Identificador del contacto a actualizar
     * @param contacto Objeto del contacto a actualizar
     */
    public Contacto updateFechaNacimiento(Integer id, Contacto contacto);

    /**
     * Actualiza la tupla completa de un teléfono en el sistema basado en su identificador
     *
     * @param id       Identificador del teléfono a actualizar
     * @param telefono Objeto del teléfono a actualizar
     */
    public Telefono updateTelefono(Integer id, Telefono telefono);

    /**
     * Actualiza la tupla completa de un email en el sistema basado en su identificador
     *
     * @param id    Identificador del teléfono a actualizar
     * @param email Objeto del teléfono a actualizar
     */
    public Email updateEmail(Integer id, Email email);

    /**
     * Borra un contacto del sistema basado en su identificador
     *
     * @param id Identificación del contacto a borrar
     */
    Contacto deleteContacto(Integer id);

    /**
     * Borra un teléfono del sistema basado en su identificador
     *
     * @param id Identificación del teléfono a borrar
     */
    Telefono deleteTelefono(Integer id);

    /**
     * Borra un email del sistema basado en su identificador
     *
     * @param id Identificación del email a borrar
     */
    Email deleteEmail(Integer id);
}