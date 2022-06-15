import React, { createContext, useState } from "react";
import { deleteContact, deleteEmail, deletePhone } from "../../apis/services";

export const Context = createContext();

/**
 * Contexto global de todo el proyecto.
 * Me guarda los contactos, telefonos, y correos.
 * @param {*} param0 
 * @returns 
 */
const Provider = ({ children }) => {
  const [contact, setContact] = useState([]);
  const [phones, setPhones] = useState([]);
  const [emails, setEmails] = useState([]);
  const [singleContact, setSingleContact] = useState([]);

  const removeItem = (id) => {
    const itemRemoved = contact.data.data.filter((item) => item.id !== id);
    setContact(itemRemoved);
  };

  const deleteSingleContact = async (id) => {
    await deleteContact(id)
      .then((item) => {
        console.log(item);
        removeItem(id);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  /**
   * Eliminación de telefonos
   * @param {} id
   */
  const deleteSinglePhone = async (id) => {
    await deletePhone(id)
      .then((item) => {
        console.log(item);
        removePhone(id);
      })
      .catch((error) => {
        console.log(error);
      });
  };
  /**
   * Remueve el item que hemos eliminado de la lista de telefonos
   */
  const removePhone = (id) => {
    const itemRemoved = singleContact.telefonos.filter(
      (item) => item.id !== id
    );
    setPhones(itemRemoved);
  };

  /**
   * Eliminación de correos
   * @param {} id
   */
  const deleteSingleEmail = async (id) => {
    await deleteEmail(id)
      .then((item) => {
        console.log(item);
        removeEmail(id);
      })
      .catch((error) => {
        console.log(error);
      });
  };
  /**
   * Remueve el item que hemos eliminado de la lista de correos
   */
  const removeEmail = (id) => {
    const itemRemoved = singleContact.emails.filter((item) => item.id !== id);
    setEmails(itemRemoved);
  };

  return (
    <Context.Provider
      value={{
        contact,
        setContact,
        deleteSingleContact,
        setSingleContact,
        singleContact,
        phones,
        setPhones,
        deleteSinglePhone,
        emails,
        setEmails,
        deleteSingleEmail,
      }}
    >
      {children}
    </Context.Provider>
  );
};

export default Provider;
