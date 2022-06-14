import React, { createContext, useState } from "react";
import { deleteContact } from "../../apis/services";

export const Context = createContext();

const Provider = ({ children }) => {
  const [contact, setContact] = useState([]);
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

    return (
        <Context.Provider
          value={{
            contact,
            setContact,
            deleteSingleContact,
            setSingleContact,
            singleContact,
          }}
        >
          {children}
        </Context.Provider>
      );
};

export default Provider;

