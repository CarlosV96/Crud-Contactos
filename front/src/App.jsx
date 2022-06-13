import React, { useState, useEffect } from "react";
import "./App.css";
import { createContact, getContacts } from "./apis/services";

function App() {
  const [nombre, setNombre] = useState("");
  const [fecha, setFecha] = useState("");
  const [contact, setContact] = useState([]);

  const body = {
    nombreCompleto: nombre,
    fechaNacimiento: fecha,
  };

  const saveContact = async () => {
    await createContact(body)
      .then((items) => {
        console.log(items);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  useEffect(() => {
    let mounted = true;
    getContacts().then((items) => {
      if (mounted) {
        setContact(items);
      }
    });
    return () => (mounted = false);
  }, []);

  //console.log("AQUI SE VE EL CONTACT", contact);
  //console.log("AQUI BAMOS A VER EL CONTACT.DATA", contact.data.data[1]);

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
                  <input
                    type="date"
                    className="form-control"
                    id="fecha"
                    onChange={(e) => setFecha(e.target.value)}
                  />
                </div>
              </div>
            </div>
          </form>
          <button onClick={() => saveContact()}>Guardar</button>
        </div>
      </div>
      <p>Aqui estaremos creando una nueva App en React</p>
      <div>
        {contact.data !== undefined 
        ?
        contact.data.data.map((item, index) => {
          return <p key={index}>{item.nombreCompleto}</p>;
        })
        : "no hay datos por mostrar"
      }
      </div>
    </div>
  );
}

export default App;

// <button className="m-2 tallas" key={size.index}>
//  {size}
// </button>
