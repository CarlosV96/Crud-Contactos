import React, { useEffect, useContext, useState } from "react";
import { Context } from "./../context/context";
import "./../../index.css";
import user from "./../../images/foto.png";
import libreta from "./../../images/libreta.png"
import { useNavigate } from "react-router-dom";
import { createContact, getContacts } from "./../../apis/services";

/**
 * Este componente es la parte principal de todo el proyecto
 * Presenta los contactos creados, con sus respectivos correos, y telefonos.
 * Permite eliminar contactos, y da la opción de modificar.
 * @returns
 */
const ContactBook = () => {
  const { contact, setContact, deleteSingleContact, setSingleContact } =
    useContext(Context);
  const [nombre, setNombre] = useState("");
  const [fecha, setFecha] = useState("");
  const navigate = useNavigate();

  const goAddPhones = (item) => {
    setSingleContact(item);
    navigate({
      pathname: "/add-phones",
    });
  };

  const goAddEmail = (item) => {
    setSingleContact(item);
    navigate({
      pathname: "/add-email",
    });
  };

  const goUpdateContact = (item) => {
    setSingleContact(item);
    navigate({
      pathname: "/update-contact",
    });
  };

  const goUpdateName = (item) => {
    setSingleContact(item);
    navigate({
      pathname: "/update-name",
    });
  };

  const goUpdateFecha = (item) => {
    setSingleContact(item);
    navigate({
      pathname: "/update-fecha",
    });
  };

  const goUpdatePhone = (item) => {
    setSingleContact(item);
    navigate({
      pathname: "/update-phone",
    });
  };

  const goUpdateEmail = (item) => {
    setSingleContact(item);
    navigate({
      pathname: "/update-email",
    });
  };

  const body = {
    nombreCompleto: nombre,
    fechaNacimiento: fecha,
  };

  const saveContact = async () => {
    await createContact(body)
      .then((items) => {
        console.log(items);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  useEffect(() => {
    let mounted = true;
    getContacts()
      .then((items) => {
        if (mounted) {
          setContact(items);
        }
      })
      .catch((error) => {
        console.log(error);
      });
  });

  return (
    <div className="contact-book">
      <div className="container">
        <div className="row">
          <h4 className="title-book">Libreta de Contactos</h4>
          <div className="col-12">
            <img src={libreta} alt="libreta" className="img-libreta" />
          </div>
          <div className="col-md-12">
            <form>
              <div className="row">
                <div className="col-md-6">
                  <div className="mb-3">
                    <label htmlFor="nombre" className="form-label">
                      Nombre Completo
                    </label>
                    <input
                      type="text"
                      className="form-control"
                      id="nombre"
                      value={nombre}
                      onChange={(e) => setNombre(e.target.value)}
                    />
                  </div>
                </div>
                <div className="col-md-6">
                  <div className="mb-3">
                    <label htmlFor="fecha" className="form-label">
                      Fecha de nacimiento
                    </label>
                    <input
                      type="date"
                      className="form-control"
                      id="fecha"
                      onChange={(e) => setFecha(e.target.value)}
                    />
                  </div>
                </div>
              </div>
            </form>
            <button onClick={() => saveContact()}>Guardar</button>
          </div>
        </div>
        <hr />
        <div>
          {contact.data !== undefined ? (
            contact.data.data.map((item, index) => {
              return (
                <div className="contact-data" key={index}>
                  <div className="row">
                    <div className="col-2">
                      <img src={user} alt="User" className="img-user" />
                    </div>
                    <div className="col">
                      <p className="label-info">Nombre Completo</p>
                      <p className="data-info">{item.nombreCompleto}</p>
                    </div>
                    <div className="col">
                      <div className="label-info">Fecha Nacimiento</div>
                      <div className="data-info">{item.fechaNacimiento}</div>
                    </div>
                    <div className="col">
                      <div className="label-info">Telefonos</div>
                      <div className="data-info">
                        {item.telefonos.length > 0 ? (
                          item.telefonos.map((item, index) => {
                            return <li key={index}> {item.telefono} </li>;
                          })
                        ) : (
                          <p> No hay telefonos para mostrar </p>
                        )}
                      </div>
                    </div>
                    <div className="col">
                      <div className="label-info">Correos</div>
                      <div className="data-info">
                        {item.emails.length > 0 ? (
                          item.emails.map((item, index) => {
                            return <li key={index}> {item.email} </li>;
                          })
                        ) : (
                          <p> No hay correos para mostrar </p>
                        )}
                      </div>
                    </div>
                    <div className="col-1 d-flex align-items-center justify-content-end">
                      <button
                        type="button"
                        className="btn-close"
                        aria-label="Close"
                        onClick={() => deleteSingleContact(item.id)}
                      ></button>
                    </div>
                  </div>
                  <div className="btn-add-data">
                    <button
                      className="add-new-data"
                      onClick={() => goAddPhones(item)}
                    >
                      Agregar Telefonos
                    </button>
                    <button
                      className="add-new-data"
                      onClick={() => goAddEmail(item)}
                    >
                      Agregar Email
                    </button>
                    <button
                      className="add-new-data"
                      onClick={() => goUpdateContact(item)}
                    >
                      Actualizar Contacto
                    </button>
                    <button
                      className="add-new-data"
                      onClick={() => goUpdateName(item)}
                    >
                      Actualizar Nombre
                    </button>
                    <button
                      className="add-new-data"
                      onClick={() => goUpdateFecha(item)}
                    >
                      Actualizar Fecha de Nacimiento
                    </button>
                    <button
                      className="add-new-data"
                      onClick={() => goUpdatePhone(item)}
                    >
                      Modificar o Eliminar Teléfonos
                    </button>
                    <button
                      className="add-new-data"
                      onClick={() => goUpdateEmail(item)}
                    >
                      Modificar o Eliminar Correos
                    </button>
                  </div>
                </div>
              );
            })
          ) : (
            <p>No hay datos por mostrar</p>
          )}
        </div>
      </div>
    </div>
  );
};

export default ContactBook;
