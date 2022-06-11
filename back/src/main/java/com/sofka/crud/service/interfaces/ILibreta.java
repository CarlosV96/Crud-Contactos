package com.sofka.crud.service.interfaces;

import com.sofka.crud.domain.Contacto;
import com.sofka.crud.domain.Email;
import com.sofka.crud.domain.Telefono;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ILibreta {

    /**
     * Devuelve una lista de Contactos con todos contactos del sistema
     */
    public List<Contacto> getList();

    /*
    /**
     * Devuelve lista de Contactos con todos contactos del sistema ordenados por el campo indicado
     * ya sea ascendente o descendente
     *
     * @param field campo por el cual ordenar
     * @param order método de ordenado ASC o DESC
     * @return Lista de contactos
     *
    public List<Contacto> getList(String field, Sort.Direction order);

    /**
     * Busca un dato por el nombre en un contacto
     *
     * @param dataToSearch Dato a buscar
     * @return Lita de contactos
     *
    public List<Contacto> buscarContacto(String dataToSearch);
*/
    /**
     * Crea un contacto
     *
     * @param contacto Objeto del contacto a crear
     * @return Objeto del contacto creado
     */
    public Contacto createContacto(Contacto contacto);

    /**
     * Crea un teléfono en el sistema a nombre de un contacto
     *
     * @param telefono Objeto del teléfono a crear
     * @return Objeto del teléfono creado
     */
    public Telefono createTelefono(Telefono telefono);

    /**
     * Crea un email en el sistema a nombre de un contacto
     *
     * @param email Objeto del email a crear
     * @return Objeto del email creado
     */
    public Email createEmail(Email email);

    /**
     * Actualiza una tupla completa de un contacto
     *
     * @param id Identificador del contacto a actualizar
     * @param contacto Objeto del contacto a actualizar
     * @return Objeto del contacto actualizado
     */
    Contacto updateContacto(Integer id, Contacto contacto);

    /**
     * Actualiza el nombre de un contacto basado en su identificador
     *
     * @param id Identificador del contacto a actualizar
     * @param contacto Objeto del contacto a actualizar
     * @return Objeto del contacto actualizado
     */
    public Contacto updateNombre(Integer id, Contacto contacto);

    /**
     * Actualiza la fecha de nacimiento de un contacto basado en su identificador
     *
     * @param id Identificador del contacto a actualizar
     * @param contacto Objeto del contacto a actualizar
     * @return Objeto del contacto actualizado
     */
    public Contacto updateFechaNacimiento(Integer id, Contacto contacto);

    /**
     * Actualiza la tupla completa de un teléfono en el sistema basado en su identificador
     *
     * @param id Identificador del teléfono a actualizar
     * @param telefono Objeto del teléfono a actualizar
     * @return Objeto del teléfono actualizado
     */
    public Telefono updateTelefono(Integer id, Telefono telefono);

    /**
     * Actualiza la tupla completa de un email en el sistema basado en su identificador
     *
     * @param id Identificador del teléfono a actualizar
     * @param email Objeto del teléfono a actualizar
     * @return Objeto del email actualizado
     */
    public Email updateEmail(Integer id, Email email);

    /**
     * Borra un contacto del sistema basado en su identificador
     *
     * @param id Identificación del contacto a borrar
     * @return Objeto del contacto borrado
     */
    Contacto deleteContacto(Integer id);

    /**
     * Borra un teléfono del sistema basado en su identificador
     *
     * @param id Identificación del teléfono a borrar
     * @return Objeto del teléfono borrado
     */
    Telefono deleteTelefono(Integer id);

    /**
     * Borra un email del sistema basado en su identificador
     *
     * @param id Identificación del email a borrar
     * @return Objeto del email borrado
     */
    Email deleteEmail(Integer id);
}

     /*
------------------------------------------------------------------------------------------
     ESTE CAMPO NO SE USA YA QUE AL MODIFICAR LA TUPLA DE TELEFONO
     SE MODIFICA LO QUE LLEVA EN SU INTERIOR QUE SOLO ES EL NUMERO TELEFÓNICO
     *
     * Actualiza solamente el teléfono de un contacto a partir del ID de la tupla del teléfono
     *
     * @param id Identificador del teléfono a actualizar
     * @param telefono Objeto del teléfono a actualizar
     * @return Objeto del teléfono actualizado
     *
    public Telefono updateOnlyTelefono(Integer id, Telefono telefono);

------------------------------------------------------------------------------------------
     ESTE CAMPO IGUAL QUE EL TELEFONO

     * Actualiza solamente el email de un contacto a partir del ID de la tupla del email
     *
     * @param id Identificador del teléfono a actualizar
     * @param email Objeto del email a actualizar
     * @return Objeto del email actualizado
     *
    public Email updateOnlyEmail(Integer id, Email email);
    */
