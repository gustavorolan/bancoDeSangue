import React from "react";
import { SeletorEstados } from "../components";
import { MediaIdadeTipoSanguineo } from "../components/media-idade-tipo-sanguineo/media-idade-tipo-sanguineo.component";
import { NumeroDeDoadoresCadaEstado } from "../components/numero-de-doadores-cada-estado/numero-de-doadores-cada-estado.component";
import { PercentualObesidadePorIdade } from "../components/percentual-obesidade-por-idade/percentual-obesidade-por-idade.component";
import { PercentualObesidadeSexo } from "../components/percentual-obesidade-sexo/percentual-obesidade-sexo-component";
import { QuantidadeDoadoresPossiveis } from "../components/quantidade-doadores-possiveis/quantidade-doadores-possiveis.component";

export const Teste = () => {
  return (
    <>
      <SeletorEstados />
      <NumeroDeDoadoresCadaEstado />
    </>
  );
};
