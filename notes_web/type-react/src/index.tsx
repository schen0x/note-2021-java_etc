import React from "react";
import ReactDOM from "react-dom";
import Form from "./ts/components/Form";
console.log("index.js as main.js");

ReactDOM.render(
  <React.StrictMode>
    <Form formName="formX" />
  </React.StrictMode>,
  document.getElementById('root')
); 