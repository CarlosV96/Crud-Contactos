import React, { useContext, useState } from "react";
import { Context } from "./../context/context";
import { useNavigate } from "react-router-dom";
import "./../../index.css";
import { putEmail } from "../../apis/services";

/**
 * Este componente me permite actualizar el correo electronico
 * seleccionado previamente de un determinado contacto.
 * @returns 
 */
const UpdateSingleEmail = () => {
  const { singleContact, emails } = useContext(Context);
  const [email, setEmail] = useState("");
  const [update, setUpdate] = useState(false);
  const navigate = useNavigate();

  const goContactBook = () => {
    navigate({
      pathname: "/",
    });
  };

  const updateEmails = (e) => {
    setEmail(e.target.value);
  };

  const body = {
    contacto: {
      id: singleContact.id,
    },
    email: email,
  };

  const updateSingleEmail = async () => {
    await putEmail(body, emails.emailId)
      .then((items) => {
        console.log(items);
        setUpdate(true);
        setEmail("");
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div className="container">
      <div className="row">
        <h4 className="title-book">Modificar Correo</h4>
        <div className="col-md-12">
          <form>
            <div className="row">
              <div className="col-md-6">
                <div className="mb-3">
                  <label htmlFor="email" className="form-label">
                    Correo
                  </label>
                  <input
                    disabled={true}
                    type="text"
                    className="form-control"
                    value={emails.email}
                  />

                  <p className="mt-3 mb-0">Ingrese nuevo correo</p>
                  <input
                    type="text"
                    className="form-control"
                    id="email"
                    value={email}
                    onChange={updateEmails}
                  />
                </div>
              </div>
            </div>
          </form>
          <button onClick={() => updateSingleEmail()}>
            Actualizar Correo
          </button>
          {update ? <p>CORREO ACTUALIZADO</p> : null}
        </div>
      </div>
      <hr />
      <button className="add-new-data" onClick={() => goContactBook()}>
        Volver al menú principal
      </button>
    </div>
  );
};

export default UpdateSingleEmail;
