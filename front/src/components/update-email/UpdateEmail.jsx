import React, { useContext } from "react";
import { Context } from "../context/context";
import { useNavigate } from "react-router-dom";
import "./../../index.css";

/**
 * Este componente me permite actualizar los correos electronicos
 * de determinado contacto.
 * @returns 
 */
const UpdateEmail = () => {
  const { singleContact, setEmails, deleteSingleEmail } =
    useContext(Context);
  const navigate = useNavigate();

  const goContactBook = () => {
    navigate({
      pathname: "/",
    });
  };

  const goUpdateSingleEmail = (item) => {
    setEmails(item);
    navigate({
      pathname: "/update-single-email",
    });
  };

  return (
    <div className="container">
      <div className="row">
        <h4 className="title-book">Modificar Correo</h4>
        <div className="col-md-12">
          {singleContact !== undefined ? (
            singleContact.emails.map((item, index) => {
              return (
                <div className="contact-data" key={index}>
                  <div className="row">
                    <div className="col">
                      <div className="label-info">Correo</div>
                      <div className="data-info">
                        <li> {item.email} </li>
                      </div>
                    </div>

                    <div className="col-1 d-flex align-items-center justify-content-end">
                      <button
                        type="button"
                        className="btn-close"
                        aria-label="Close"
                        onClick={() => deleteSingleEmail(item.emailId)}
                      ></button>
                    </div>
                  </div>
                  <div className="btn-add-data">
                    <button
                      className="add-new-data"
                      onClick={() => goUpdateSingleEmail(item)}
                    >
                      Modificar Correo
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
      <hr />
      <button className="add-new-data" onClick={() => goContactBook()}>
        Volver al menú principal
      </button>
    </div>
  );
};

export default UpdateEmail;
