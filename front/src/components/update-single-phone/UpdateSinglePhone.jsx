import React, { useContext, useState } from "react";
import { Context } from "./../context/context";
import { useNavigate } from "react-router-dom";
import "./../../index.css";
import { putPhone } from "../../apis/services";

/**
 * Este componente me permite actualizar el telefono
 * seleccionado previamente de un determinado contacto.
 * @returns 
 */
const UpdateSinglePhone = () => {
  const { singleContact, phones } = useContext(Context);
  const [phone, setPhone] = useState("");
  const [update, setUpdate] = useState(false);
  const navigate = useNavigate();

  const goContactBook = () => {
    navigate({
      pathname: "/",
    });
  };

  const updatePhones = (e) => {
    setPhone(e.target.value);
  };

  const body = {
    contacto: {
      id: singleContact.id,
    },
    telefono: phone,
  };

  const updateSinglePhone = async () => {
    await putPhone(body, phones.telId)
      .then((items) => {
        console.log(items);
        setUpdate(true);
        setPhone("");
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div className="container">
      <div className="row">
        <h4 className="title-book">Modificar Telefono</h4>
        <div className="col-md-12">
          <form>
            <div className="row">
              <div className="col-md-6">
                <div className="mb-3">
                  <label htmlFor="nombre" className="form-label">
                    Teléfono
                  </label>
                  <input
                    disabled={true}
                    type="text"
                    className="form-control"
                    value={phones.telefono}
                  />

                  <p className="mt-3 mb-0">Ingrese nuevo telefono</p>
                  <input
                    type="text"
                    className="form-control"
                    id="phone"
                    value={phone}
                    onChange={updatePhones}
                  />
                </div>
              </div>
            </div>
          </form>
          <button onClick={() => updateSinglePhone()}>
            Actualizar Teléfono
          </button>
          {update ? <p>TELEFONO ACTUALIZADO</p> : null}
        </div>
      </div>
      <hr />
      <button className="add-new-data" onClick={() => goContactBook()}>
        Volver al menú principal
      </button>
    </div>
  );
};

export default UpdateSinglePhone;
