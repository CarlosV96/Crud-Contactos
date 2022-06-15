import { BrowserRouter, Routes, Route } from "react-router-dom";
import Provider from "./../context/context";
import AddEmail from "../add-email/AddEmail";
import AddPhones from "../add-phones/AddPhones";
import ContactBook from "../contact-book/ContactBook";
import UpdateContact from "./../update-contact/UpdateContact";
import UpdateName from "./../update-name/UpdateName";
import UpdateFecha from "../update-fecha/UpdateFecha";
import UpdatePhone from "../update-phone/UpdatePhone";
import UpdateSinglePhone from "../update-single-phone/UpdateSinglePhone";
import UpdateEmail from "../update-email/UpdateEmail";
import UpdateSingleEmail from "../update-single-email/UpdateSingleEmail";

/**
 * Manejo de rutas
 * @returns 
 */
export default function RoutesApp() {
  return (
    <Provider>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<ContactBook />} />
          <Route path="/add-phones" element={<AddPhones />} />
          <Route path="/add-email" element={<AddEmail />} />
          <Route path="/update-contact" element={<UpdateContact />} />
          <Route path="/update-name" element={<UpdateName />} />
          <Route path="/update-fecha" element={<UpdateFecha />} />
          <Route path="/update-phone" element={<UpdatePhone />} />
          <Route path="/update-single-phone" element={<UpdateSinglePhone />} />
          <Route path="/update-email" element={<UpdateEmail />} />
          <Route path="/update-single-email" element={<UpdateSingleEmail />} />
        </Routes>
      </BrowserRouter>
    </Provider>
  );
}
