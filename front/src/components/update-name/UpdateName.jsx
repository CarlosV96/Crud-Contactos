import React, { useContext, useState } from "react";
import { Context } from "./../context/context";
import { useNavigate } from "react-router-dom";
import "./../../index.css";
import { patchName } from "./../../apis/services";

const UpdateName = () => {
  const { singleContact } = useContext(Context);
  const [nombre, setNombre] = useState("");
  const [update, setUpdate] = useState(false);
  const navigate = useNavigate();

  const goContactBook = () => {
    navigate({
      pathname: "/",
    });
  };

  const updateNames = (e) => {
    setNombre(e.target.value);
    //singleContact.nombreCompleto = e.target.value;
  };

  const body = {
    nombreCompleto: nombre,
  };

  const updateSingleName = async () => {
    await patchName(body, singleContact.id)
      .then((items) => {
        console.log(items);
        setUpdate(true);
        setNombre("");
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div className="container">
      <div className="row">
        <h4 className="title-book">Modificar Nombre</h4>
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
                    onChange={updateNames}
                  />
                </div>
              </div>
            </div>
          </form>
          <button onClick={() => updateSingleName()}>Actualizar Nombre</button>
          {update ? <p>NOMBRE ACTUALIZADO</p> : null}
        </div>
      </div>
      <hr />
      <button className="add-new-data" onClick={() => goContactBook()}>
        Volver al menú principal
      </button>
    </div>
  );
};

export default UpdateName;
