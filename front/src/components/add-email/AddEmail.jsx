import React, { useEffect, useContext, useState } from "react";
import { Context } from "./../context/context";
import { useNavigate } from "react-router-dom";
import "./../../index.css";
import { createEmail } from "./../../apis/services";

function AddEmail() {
  const { contact, singleContact } = useContext(Context);
  const [correo, setCorreo] = useState("");
  const navigate = useNavigate();

  const goContactBook = () => {
    navigate({
      pathname: "/",
    });
  };

  const body = {
    contacto: {
      id: singleContact.id,
    },
    email: correo,
  };

  const saveEmail = async () => {
    await createEmail(body)
      .then((items) => {
        console.log(items);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div className="contact-book-phones">
      <div className="container">
        <div className="row">
          <h4 className="title-book">Agregar Email</h4>
          <div className="col-md-12">
            <form>
              <div className="row">
                <div className="col-md-12">
                  <div className="mb-3">
                    <label htmlFor="email" className="form-label">
                      Telefono
                    </label>
                    <input
                      type="text"
                      className="form-control"
                      id="email"
                      value={correo}
                      onChange={(e) => setCorreo(e.target.value)}
                    />
                  </div>
                </div>
              </div>
            </form>

            <button onClick={() => saveEmail()}>Guardar</button>
          </div>
        </div>
        <hr />
        <button className="add-new-data" onClick={() => goContactBook()}>
          Volver al menú principal
        </button>
      </div>
    </div>
  );
}

export default AddEmail;
