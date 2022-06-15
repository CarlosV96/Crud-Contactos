import axios from "axios";

/**
 * Esta función hace el consumo con el back para crear un nuevo contacto
 * @param {*} body 
 * @returns 
 */
export const createContact = async (body) => {
  const url = "http://localhost:8080/api/v1/contacto";
  try {
    const response = await axios.post(url, body, {
      headers: {
        "Access-Control-Allow-Origin": "*",
      },
    });
    return response;
  } catch (error) {
    return error;
  }
};

/**
 * Esta función hace el consumo con el back para obtener todos los contactos
 * @returns La respuesta de la API en este caso, todos los contactos.
 */
export const getContacts = async () => {
  const url = "http://localhost:8080/api/v1/index";
  try {
    const response = await axios.get(url, {
      headers: {
        "Access-Control-Allow-Origin": "*",
      },
    });
    return response;
  } catch (error) {
    return error;
  }
};

/**
 * Delete
 * a un contacto
 * @param {*} body 
 * @returns 
 */
 export const deleteContact = async (id) => {
  const url = "http://localhost:8080/api/v1/contacto/" + id;
  try {
    const response = await axios.delete(url, {
      headers: {
        "Access-Control-Allow-Origin": "*",
      },
    });
    return response;
  } catch (error) {
    return error;
  }
};

/**
 * Esta función hace el consumo con el back para actualizar la tupla completa de un
 * contacto
 * @param {*} body 
 * @returns 
 */
 export const putContact = async (body, id) => {
  const url = "http://localhost:8080/api/v1/contacto/" + id;
  try {
    const response = await axios.put(url, body, {
      headers: {
        "Access-Control-Allow-Origin": "*",
      },
    });
    //return (response => this.setState({ updatedAt: response.data.updatedAt }));
    return response;
  } catch (error) {
    return error;
  }
};

/**
 * Esta función hace el consumo con el back para crearle un nuevo telefono
 * a un contacto
 * @param {*} body 
 * @returns 
 */
export const createPhone = async (body) => {
  const url = "http://localhost:8080/api/v1/telefono";
  try {
    const response = await axios.post(url, body, {
      headers: {
        "Access-Control-Allow-Origin": "*",
      },
    });
    return response;
  } catch (error) {
    return error;
  }
};

/**
 * Esta función hace el consumo con el back para crearle un nuevo email
 * a un contacto
 * @param {*} body 
 * @returns 
 */
 export const createEmail = async (body) => {
  const url = "http://localhost:8080/api/v1/email";
  try {
    const response = await axios.post(url, body, {
      headers: {
        "Access-Control-Allow-Origin": "*",
      },
    });
    return response;
  } catch (error) {
    return error;
  }
};

/**
 * Esta función hace el consumo con el back para actualizar el nombre de un
 * contacto
 * @param {*} body 
 * @returns 
 */
 export const patchName = async (body, id) => {
  const url = "http://localhost:8080/api/v1/contacto/" + id + "/name";
  try {
    const response = await axios.patch(url, body, {
      headers: {
        "Access-Control-Allow-Origin": "*",
      },
    });
    //return (response => this.setState({ updatedAt: response.data.updatedAt }));
    return response;
  } catch (error) {
    return error;
  }
};

/**
 * Esta función hace el consumo con el back para actualizar la fecha de
 * nacimiento de un contacto
 * @param {*} body 
 * @returns 
 */
 export const patchFecha = async (body, id) => {
  const url = "http://localhost:8080/api/v1/contacto/" + id + "/fecha";
  try {
    const response = await axios.patch(url, body, {
      headers: {
        "Access-Control-Allow-Origin": "*",
      },
    });
    //return (response => this.setState({ updatedAt: response.data.updatedAt }));
    return response;
  } catch (error) {
    return error;
  }
};

/**
 * Esta función hace el consumo con el back para actualizar la tupla completa de un
 * telefono
 * @param {*} body 
 * @returns 
 */
 export const putPhone = async (body, id) => {
  const url = "http://localhost:8080/api/v1/telefono/" + id;
  try {
    const response = await axios.put(url, body, {
      headers: {
        "Access-Control-Allow-Origin": "*",
      },
    });
   
    return response;
  } catch (error) {
    return error;
  }
};