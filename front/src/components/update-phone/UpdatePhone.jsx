import React, { useContext } from "react";
import { Context } from "./../context/context";
import { useNavigate } from "react-router-dom";
import "./../../index.css";

/**
 * Este componente me permite actualizar los telefonos
 * de determinado contacto.
 * @returns 
 */
const UpdatePhone = () => {
  const { singleContact, setPhones, deleteSinglePhone } =
    useContext(Context);
  const navigate = useNavigate();

  const goContactBook = () => {
    navigate({
      pathname: "/",
    });
  };

  const goUpdateSinglePhone = (item) => {
    setPhones(item);
    navigate({
      pathname: "/update-single-phone",
    });
  };

  return (
    <div className="container">
      <div className="row">
        <h4 className="title-book">Modificar Telefono</h4>
        <div className="col-md-12">
          {singleContact !== undefined ? (
            singleContact.telefonos.map((item, index) => {
              return (
                <div className="contact-data" key={index}>
                  <div className="row">
                    <div className="col">
                      <div className="label-info">Telefono</div>
                      <div className="data-info">
                        <li> {item.telefono} </li>
                      </div>
                    </div>

                    <div className="col-1 d-flex align-items-center justify-content-end">
                      <button
                        type="button"
                        className="btn-close"
                        aria-label="Close"
                        onClick={() => deleteSinglePhone(item.telId)}
                      ></button>
                    </div>
                  </div>
                  <div className="btn-add-data">
                    <button
                      className="add-new-data"
                      onClick={() => goUpdateSinglePhone(item)}
                    >
                      Modificar Telefono
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

export default UpdatePhone;
