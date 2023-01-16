import React from "react";
import { Routes, Route } from "react-router-dom";
import { Login } from "../../screen";
import { Teste } from "../../screen/teste";

export const TodasRotas = () => {
  return (
    <Routes>
      <Route path="/login" element={<Login />} />
      <Route path="/teste" element={<Teste />} />
    </Routes>
  );
};
