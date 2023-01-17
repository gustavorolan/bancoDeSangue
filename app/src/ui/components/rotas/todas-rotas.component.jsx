import React from "react";
import { Routes, Route } from "react-router-dom";
import {
  Login,
  Perfil,
  PercentualObesidadePorIdadeScreen,
  PercentualObesidadeSexoScreen,
  MediaIdadeTipoSanguineoScreen,
  NumeroDeDoadoresCadaEstadoScreen,
  QuantidadeDoadoresPossiveisScreen,
  Menu
} from "../../screen";

export const TodasRotas = () => {
  return (
    <Routes>
      <Route path="/login" element={<Login />} />
      <Route path="/perfil" element={<Perfil />} />
      <Route path="/menu" element={<Menu />} />
      <Route
        path="/PercentualObesidadePorIdade"
        element={<PercentualObesidadePorIdadeScreen />}
      />
      <Route
        path="/PercentualObesidadeSexo"
        element={<PercentualObesidadeSexoScreen />}
      />
      <Route
        path="/mediaIdadeTipoSanguineo"
        element={<MediaIdadeTipoSanguineoScreen />}
      />
      <Route
        path="/numeroDeDoadoresCadaEstado"
        element={<NumeroDeDoadoresCadaEstadoScreen />}
      />
      <Route
        path="/quantidadeDoadoresPossiveis"
        element={<QuantidadeDoadoresPossiveisScreen />}
      />
    </Routes>
  );
};
