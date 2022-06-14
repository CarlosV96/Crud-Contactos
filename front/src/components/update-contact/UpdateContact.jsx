import React, { useContext, useState } from "react";
import { Context } from "./../context/context";
import { useNavigate } from "react-router-dom";
import "./../../index.css";
import { putContact } from "./../../apis/services";

const UpdateContact = () => {
  const { contact, singleContact, setSingleContact } = useContext(Context);
  const [nombre, setNombre] = useState("");
  const [fecha, setFecha] = useState("");
  const [update, setUpdate] = useState(false);

  const updateName = (e) => {
    setNombre(e.target.value);
    //singleContact.nombreCompleto = e.target.value;
  };

  const updateFecha = (e) => {
    setFecha(e.target.value);
    //singleContact.nombreCompleto = e.target.value;
  };

  const body = {
    nombreCompleto: nombre,
    fechaNacimiento: fecha,
  };

  const updateSingleContact = async () => {
    await putContact(body, singleContact.id)
      .then((items) => {
        console.log(items);
        setUpdate(true);
        setNombre("");
        setFecha("");
      })
      .catch((error) => {
        console.log(error);
      });
  };

  //console.log("SINGLE CONTACT ", singleContact);

  return (
    <div className="container">
      <div className="row">
        <h4 className="title-book">Modificar Contacto</h4>
        <div className="col-md-12">
          <form>
            <div className="row">
              <div className="col-md-6">
                <div className="mb-3">
                  <label htmlFor="nombre" className="form-label">
                    Nombre
                  </label>
                  <input
                    disabled={true}
                    type="text"
                    className="form-control"
                    value={singleContact.nombreCompleto}
                  />

                  <p className="mt-3 mb-0">Ingrese nuevo nombre</p>
                  <input
                    type="text"
                    className="form-control"
                    id="nombre"
                    value={nombre}
                    onChange={updateName}
                  />
                </div>
              </div>
              <div className="col-md-6">
                <div className="mb-3">
                  <label htmlFor="fecha" className="form-label">
                    Fecha de nacimiento
                  </label>
                  <input
                    disabled={true}
                    type="date"
                    className="form-control"
                    value={singleContact.fechaNacimiento}
                  />
                  <p className="mt-3 mb-0">Ingrese nueva fecha</p>
                  <input
                    type="date"
                    className="form-control"
                    id="fecha"
                    value={fecha}
                    onChange={updateFecha}
                  />
                </div>
              </div>
            </div>
          </form>
          <button onClick={() => updateSingleContact()}>
            Actualizar Contacto
          </button>
          {update ? <p>CONTACTO ACTUALIZADO</p> : null}
        </div>
      </div>
      <hr />
    </div>
  );
};

export default UpdateContact;
