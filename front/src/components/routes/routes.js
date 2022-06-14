import { BrowserRouter, Routes, Route } from "react-router-dom";
import Provider from "./../context/context";
// import App from "../../App";
import AddEmail from "../add-email/AddEmail";
import AddPhones from "../add-phones/AddPhones";
import ContactBook from "../contact-book/ContactBook";
import UpdateContact from "./../update-contact/UpdateContact";

export default function RoutesApp() {
  return (
    <Provider>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<ContactBook />} />
          <Route path="/add-phones" element={<AddPhones />} />
          <Route path="/add-email" element={<AddEmail />} />
          <Route path="/update-contact" element={<UpdateContact />} />
        </Routes>
      </BrowserRouter>
    </Provider>
  );
}
