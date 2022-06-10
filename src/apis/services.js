import axios from "axios";

export const createContact = async (body) => {
  const url = "localhost:8080/api/v1/contacto";
  try {
    const response = await axios.post(url, body);
    return response;
  } catch (error) {
    return error;
  }
};
