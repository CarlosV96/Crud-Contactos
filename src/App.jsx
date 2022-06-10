import React, { useState, useEffect } from "react";
import "./App.css";
import {createContact} from "./apis/services";

function App() {
  const [nombre, setNombre] = useState("");
  const [fecha, setFecha] = useState("");
  const [contact, setContact] = useState([]);

  const body = {
    "nombreCompleto" : nombre,
    "fechaNacimiento": fecha
  }

  const saveContact = async () => {
    await createContact(body)
      .then(items => {
          setContact(items)
      })
      .catch((error) => {
        console.log(error);
      });
  }
console.log("CONTACT", contact);
  return (
    <div className="container">
      <div className="row">
        <div className="col-md-12">
          <form>
            <div className="row">
              <div className="col-md-6">
                <div className="mb-3">
                  <label htmlFor="nombre" className="form-label">
                    Nombre
                  </label>
                  <input
                    type="text"
                    className="form-control"
                    id="nombre"
                    value={nombre}
                    onChange={(e) => setNombre(e.target.value)}
                  />
                </div>
              </div>
              <div className="col-md-6">
                <div className="mb-3">
                  <label htmlFor="fecha" className="form-label">
                    Fecha de nacimiento
                  </label>
                  <input type="date" className="form-control" id="fecha" onChange={(e) => setFecha(e.target.value)} />
                </div>
              </div>
            </div>
          </form>
          <button onClick={() => saveContact()}>Guardar</button>
        </div>
      </div>
      <p>Aqui estaremos creando una nueva App en React</p>
    </div>
  );
}

export default App;
