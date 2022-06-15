import React, { useContext, useState } from "react";
import { Context } from "./../context/context";
import { useNavigate } from "react-router-dom";
import "./../../index.css";
import { patchFecha } from "./../../apis/services";

/**
 * Este componente me permite actualizar la fecha de nacimiento
 * de determinado contacto.
 * @returns 
 */
const UpdateFecha = () => {
  const { singleContact } = useContext(Context);
  const [fecha, setFecha] = useState("");
  const [update, setUpdate] = useState(false);
  const navigate = useNavigate();

  const goContactBook = () => {
    navigate({
      pathname: "/",
    });
  };

  const updateFecha = (e) => {
    setFecha(e.target.value);
  };

  const body = {
    fechaNacimiento: fecha,
  };

  const updateSingleFecha = async () => {
    await patchFecha(body, singleContact.id)
      .then((items) => {
        console.log(items);
        setUpdate(true);
        setFecha("");
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
          <button onClick={() => updateSingleFecha()}>Actualizar Fecha</button>
          {update ? <p>FECHA ACTUALIZADA</p> : null}
        </div>
      </div>
      <hr />
      <button className="add-new-data" onClick={() => goContactBook()}>
        Volver al menú principal
      </button>
    </div>
  );
};

export default UpdateFecha;
