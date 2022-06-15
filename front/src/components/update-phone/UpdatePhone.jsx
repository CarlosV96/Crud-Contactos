import React, { useContext, useState } from "react";
import { Context } from "./../context/context";
import { useNavigate } from "react-router-dom";
import "./../../index.css";
import { putContact, putPhone } from "./../../apis/services";

const UpdatePhone = () => {
  const { contact, singleContact, setSingleContact } = useContext(Context);
  const [phone, setPhone] = useState("");
  const [update, setUpdate] = useState(false);
  const navigate = useNavigate();

  const goContactBook = () => {
    navigate({
      pathname: "/",
    });
  };

  const updatePhone = (e) => {
    setPhone(e.target.value);
    
  };


  const body = {
    contacto : {
        id: contact
    },
    telefono: phone
}

  const updateSinglePhone = async () => {
    await putPhone(body, singleContact.id)
      .then((items) => {
        console.log(items);
        setUpdate(true);
        setPhone("");
      })
      .catch((error) => {
        console.log(error);
      });
  };

  console.log("BUSCANDO NUMERO", singleContact.telefonos[1]);

  return (
    <div className="container">
      <div className="row">
        <h4 className="title-book">Modificar Telefono</h4>
        <div className="col-md-12">
          <form>
            <div className="row">
              <div className="col-md-12">
                <div className="mb-3">
                  <label htmlFor="phone" className="form-label">
                    Numero Telefonico
                  </label>
                  <input
                    disabled={true}
                    type="text"
                    className="form-control"
                    value={singleContact.telefonos}
                  />

                  <p className="mt-3 mb-0">Ingrese nuevo numero telefonico</p>
                  <input
                    type="text"
                    className="form-control"
                    id="phone"
                    value={phone}
                    onChange={updatePhone}
                  />
                </div>
              </div>
            </div>
          </form>
          <button onClick={() => updateSinglePhone()}>
            Actualizar Telefono
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

export default UpdatePhone;