package com.sofka.crud.controller;

import com.sofka.crud.domain.Contacto;
import com.sofka.crud.domain.Email;
import com.sofka.crud.domain.Telefono;
import com.sofka.crud.service.LibretaService;
import com.sofka.crud.utility.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@Slf4j
@RestController
public class CrudController {

    @Autowired
    private LibretaService libretaService;

    private Response response = new Response();

    private HttpStatus httpStatus = HttpStatus.OK;

    @GetMapping(path = "/")
    public ResponseEntity<Response> homeIndex1(HttpServletResponse httpResponse) {
        return getResponseHome(httpResponse);
    }

    @GetMapping(path = "/api/")
    public ResponseEntity<Response> homeIndex2(HttpServletResponse httpResponse) {
        return getResponseHome(httpResponse);
    }

    @GetMapping(path = "/api/v1/")
    public ResponseEntity<Response> homeIndex3(HttpServletResponse httpResponse) {
        return getResponseHome(httpResponse);
    }

    /**
     * Index del sistema, responde con el listado de contactos con sus teléfonos y sus emails
     *
     * @return Objeto Response en formato JSON
     */
    @CrossOrigin
    @GetMapping(path = "/api/v1/index")
    public ResponseEntity<Response> index() {
        response.restart();
        try {
            response.data = libretaService.getList();
            httpStatus = HttpStatus.OK;
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity(response, httpStatus);
    }
/*
    /**
     * Devuelve todos los contactos con sus teléfonos y emails ordenados por nombre de forma ascendente o descendente
     *
     * @param orderBy Nombre del campo por donde se desea ordenar la información
     * @param order Tipo de orden que debe tener la información ASC o DESC
     * @return Objeto Response en formato JSON
     *
    @GetMapping(path = "/api/v1/index/orderby/{orderBy}/{order}")
    public ResponseEntity<Response> indexOrderBy(
            @PathVariable(value="orderBy") String orderBy,
            @PathVariable(value="order") Sort.Direction order
    ) {
        response.restart();
        try {
            response.data = libretaService.getList(orderBy, order);
            httpStatus = httpStatus.OK;
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity(response, httpStatus);
    }

    /**
     * Devuelve el listado de contactos y sus teléfonos basados en un datos a buscar por nombre
     *
     * @param dataToSearch Información a buscar
     * @return Objeto Response en formato JSON
     *
    @GetMapping(path = "/api/v1/buscar/contacto/{dataToSearch}")
    public ResponseEntity<Response> searchContactByNombre(
            @PathVariable(value="dataToSearch") String dataToSearch
    ) {
        response.restart();
        try {
            response.data = libretaService.buscarContacto(dataToSearch);
            httpStatus = HttpStatus.OK;
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity(response, httpStatus);
    }
*/

    /**
     * Crea un nuevo contacto
     *
     * @param contacto Objeto Contacto acrear
     * @return Objeto Response en formato JSON
     */
    @CrossOrigin
    @PostMapping(path = "/api/v1/contacto")
    public ResponseEntity<Response> createContacto(@RequestBody Contacto contacto) {
        response.restart();
        try {
            log.info("Contacto a crear: {}", contacto);
            response.data = libretaService.createContacto(contacto);
            httpStatus = HttpStatus.CREATED;
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity(response, httpStatus);
    }

    /**
     * Crea un telefono en el sistema a nombre de un contacto
     *
     * @param telefono Objeto Telefono a crear
     * @return Objeto Response en formato JSON
     */
    @PostMapping(path = "/api/v1/telefono")
    public ResponseEntity<Response> createTelefono(@RequestBody Telefono telefono) {
        response.restart();
        try {
            log.info("Telefono a crear: {}", telefono);
            response.data = libretaService.createTelefono(telefono);
            httpStatus = HttpStatus.CREATED;
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity(response, httpStatus);
    }

    /**
     * Crea un email en el sistema a nombre de un contacto
     *
     * @param email Objeto Email a crear
     * @return Objeto Response en formato JSON
     */
    @PostMapping(path = "/api/v1/email")
    public ResponseEntity<Response> createEmail(@RequestBody Email email) {
        response.restart();
        try {
            log.info("Email a crear: {}", email);
            response.data = libretaService.createEmail(email);
            httpStatus = HttpStatus.CREATED;
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity(response, httpStatus);
    }

    /**
     * Actualiza todos los campos de un contacto
     *
     * @param contacto Objeto contacto a actualizar
     * @param id       Identificador del contacto a actualizar
     * @return Objeto Response en formato JSON
     */
    @PutMapping(path = "/api/v1/contacto/{id}")
    public ResponseEntity<Response> updateContacto(
            @RequestBody Contacto contacto,
            @PathVariable(value = "id") Integer id
    ) {
        response.restart();
        try {
            response.data = libretaService.updateContacto(id, contacto);
            httpStatus = HttpStatus.OK;
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity(response, httpStatus);
    }

    /**
     * Actualiza el nombre de un contacto basado en su identificador
     *
     * @param contacto Objeto Contacto
     * @param id       Identificador del contacto a actualizar
     * @return Objeto Response en formato JSON
     */
    @PatchMapping(path = "/api/v1/contacto/{id}/name")
    public ResponseEntity<Response> updateNombreFromContacto(
            @RequestBody Contacto contacto,
            @PathVariable(value = "id") Integer id
    ) {
        response.restart();
        try {
            response.data = libretaService.updateNombre(id, contacto);
            httpStatus = HttpStatus.OK;
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity(response, httpStatus);
    }

    /**
     * Actualiza la fecha de nacimiento de un contacto basado en su identificador
     *
     * @param contacto Objeto Contacto
     * @param id       Identificador del contacto a actualizar
     * @return Objeto Response en formato JSON
     */
    @PatchMapping(path = "/api/v1/contacto/{id}/fecha")
    public ResponseEntity<Response> updateFechaFromContacto(
            @RequestBody Contacto contacto,
            @PathVariable(value = "id") Integer id
    ) {
        response.restart();
        try {
            response.data = libretaService.updateFechaNacimiento(id, contacto);
            httpStatus = HttpStatus.OK;
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity(response, httpStatus);
    }

    /**
     * Actualiza todos los campos del teléfono
     *
     * @param telefono Objeto telefono a actualizar
     * @param id       Identificador del número de teléfono a actualizar
     * @return Objeto Response en formato JSON
     */
    @PutMapping(path = "/api/v1/telefono/{id}")
    public ResponseEntity<Response> updateTelefono(
            @RequestBody Telefono telefono,
            @PathVariable(value = "id") Integer id
    ) {
        response.restart();
        try {
            response.data = libretaService.updateTelefono(id, telefono);
            httpStatus = HttpStatus.OK;
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity(response, httpStatus);
    }


    /**
     * Actualiza todos los campos de un email
     *
     * @param email Objeto telefono a actualizar
     * @param id    Identificador del email a actualizar
     * @return Objeto Response en formato JSON
     */
    @PutMapping(path = "/api/v1/email/{id}")
    public ResponseEntity<Response> updateEmail(
            @RequestBody Email email,
            @PathVariable(value = "id") Integer id
    ) {
        response.restart();
        try {
            response.data = libretaService.updateEmail(id, email);
            httpStatus = HttpStatus.OK;
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity(response, httpStatus);
    }


    /**
     * Borra un contacto del sistema
     *
     * @param id Identificador del contacto a borrar
     * @return Objeto Response en formato JSON
     */
    @DeleteMapping(path = "/api/v1/contacto/{id}")
    public ResponseEntity<Response> deleteContacto(@PathVariable(value = "id") Integer id) {
        response.restart();
        try {
            response.data = libretaService.deleteContacto(id);
            if (response.data == null) {
                response.message = "El contacto no existe";
                httpStatus = HttpStatus.NOT_FOUND;
            } else {
                response.message = "El contacto fue removido exitosamente";
                httpStatus = HttpStatus.OK;
            }
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity(response, httpStatus);
    }

    /**
     * Borra un teléfono del sistema
     *
     * @param id Identificador del teléfono a borrar
     * @return Objeto Response en formato JSON
     */
    @DeleteMapping(path = "/api/v1/telefono/{id}")
    public ResponseEntity<Response> deleteTelefono(@PathVariable(value = "id") Integer id) {
        response.restart();
        try {
            response.data = libretaService.deleteTelefono(id);
            if (response.data == null) {
                response.message = "El telefono no existe";
                httpStatus = HttpStatus.NOT_FOUND;
            } else {
                response.message = "El telefono fue removido exitosamente";
                httpStatus = HttpStatus.OK;
            }
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity(response, httpStatus);
    }

    /**
     * Borra un email del sistema
     *
     * @param id Identificador del email a borrar
     * @return Objeto Response en formato JSON
     */
    @DeleteMapping(path = "/api/v1/email/{id}")
    public ResponseEntity<Response> deleteEmail(@PathVariable(value = "id") Integer id) {
        response.restart();
        try {
            response.data = libretaService.deleteEmail(id);
            if (response.data == null) {
                response.message = "El email no existe";
                httpStatus = HttpStatus.NOT_FOUND;
            } else {
                response.message = "El email fue removido exitosamente";
                httpStatus = HttpStatus.OK;
            }
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity(response, httpStatus);
    }

    /**
     * Administrador para la redirección al controllador /api/v1/index
     *
     * @param httpResponse Objeto HttpServletResponse para el manejo de la redirección
     * @return Objeto Response en formato JSON
     */
    private ResponseEntity<Response> getResponseHome(HttpServletResponse httpResponse) {
        response.restart();
        try {
            httpResponse.sendRedirect("/api/v1/index");
        } catch (IOException exception) {
            response.error = true;
            response.data = exception.getCause();
            response.message = exception.getMessage();
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity(response, httpStatus);
    }

    /**
     * Administrador para las excepciones del sistema
     *
     * @param exception Objeto Exception
     */
    private void getErrorMessageInternal(Exception exception) {
        response.error = true;
        response.message = exception.getMessage();
        response.data = exception.getCause();
        httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    /**
     * Administrador para las excepciones a nivel de SQL con respecto al manejo del acceso a los datos
     *
     * @param exception Objeto DataAccessException
     */
    private void getErrorMessageForResponse(DataAccessException exception) {
        response.error = true;
        if (exception.getRootCause() instanceof SQLException) {
            SQLException sqlEx = (SQLException) exception.getRootCause();
            var sqlErrorCode = sqlEx.getErrorCode();
            switch (sqlErrorCode) {
                case 1062:
                    response.message = "El dato ya está registrado";
                    break;
                case 1452:
                    response.message = "El usuario indicado no existe";
                    break;
                default:
                    response.message = exception.getMessage();
                    response.data = exception.getCause();
            }
            httpStatus = HttpStatus.BAD_REQUEST;
        } else {
            response.message = exception.getMessage();
            response.data = exception.getCause();
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}

    /*
     ESTE CAMPO NO SE USA YA QUE AL MODIFICAR LA TUPLA DE TELEFONO
     SE MODIFICA LO QUE LLEVA EN SU INTERIOR QUE SOLO ES EL NUMERO TELEFÓNICO
     *
     * Actualiza el número de teléfono basado en su identificador
     *
     * @param telefono Objeto Contacto
     * @param id Identificador del número de teléfono a actualizar
     * @return Objeto Response en formato JSON
     *
    @PatchMapping(path = "/api/v1/telefono/{id}/numero")
    public ResponseEntity<Response> updateOnlyTelefono(
            @RequestBody Telefono telefono,
            @PathVariable(value="id") Integer id
    ) {
        response.restart();
        try {
            response.data = libretaService.updateOnlyTelefono(id, telefono);
            httpStatus = HttpStatus.OK;
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity(response, httpStatus);
    }
-----------------------------------------------------------------------------------
     ESTE CAMPO IGUAL QUE EL NUMERO TELEFONICO

     * Actualiza el email basado en su identificador
     *
     * @param email Objeto Contacto
     * @param id Identificador del número de teléfono a actualizar
     * @return Objeto Response en formato JSON
     *
    @PatchMapping(path = "/api/v1/email/{id}/correo")
    public ResponseEntity<Response> updateOnlyEmail(
            @RequestBody Email email,
            @PathVariable(value="id") Integer id
    ) {
        response.restart();
        try {
            response.data = libretaService.updateOnlyEmail(id, email);
            httpStatus = HttpStatus.OK;
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity(response, httpStatus);
    }
     */
