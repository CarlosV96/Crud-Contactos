import axios from "axios";

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