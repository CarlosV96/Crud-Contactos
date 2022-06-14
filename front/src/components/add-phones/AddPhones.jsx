import React, { useEffect, useContext, useState } from "react";
import { Context } from "./../context/context";
import { useNavigate } from "react-router-dom";
import "./../../index.css";
import { createPhone } from "./../../apis/services";

const AddPhones = () => {
  const { contact, singleContact } = useContext(Context);
  const [phone, setPhone] = useState("");
  const navigate = useNavigate();
  
  const goContactBook = () => {
    navigate({
      pathname: "/",
    });
  };

  const body = {
    contacto: {
      id: contact.data.data[1].id
    },
    telefono: phone,
  };

  const savePhone = async () => {
    await createPhone(body)
      .then((items) => {
        console.log(items);
      })
      .catch((error) => {
        console.log(error);
      });
  };
  console.log("CONTACTO ", singleContact);

  return (
    <div className="contact-book-phones">
      <div className="container">
        <div className="row">
          <h4 className="title-book">Agregar Teléfonos</h4>
          <div className="col-md-12">
            <form>
              <div className="row">
                <div className="col-md-12">
                  <div className="mb-3">
                    <label htmlFor="telefono" className="form-label">
                      Telefono
                    </label>
                    <input
                      type="text"
                      className="form-control"
                      id="telefono"
                      value={phone}
                      onChange={(e) => setPhone(e.target.value)}
                    />
                  </div>
                </div>
              </div>
            </form>

            <button onClick={() => savePhone()}>Guardar</button>
          </div>
        </div>
        <hr />

        <button className="add-new-data" onClick={() => goContactBook()}>
          Volver al menú principal
        </button>
      </div>
      </div>

  );
};

export default AddPhones;

