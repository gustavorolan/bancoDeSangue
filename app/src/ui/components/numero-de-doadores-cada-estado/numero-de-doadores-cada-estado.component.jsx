import React, { useEffect, useState } from "react";
import { useBancoDeSangueApi } from "../../../hooks/api";

export const NumeroDeDoadoresCadaEstado = () => {
  const { getNumeroDeDoadoresCadaEstado } = useBancoDeSangueApi();
  const [numeroDeDoadoresCadaEstado, setNumeroDeDoadoresCadaEstado] = useState(
    []
  );
  useEffect(() => {
    const getPercentualObesidadeApi = async () => {
      const numeroDeDoadoresCadaEstadoResponse =
        await getNumeroDeDoadoresCadaEstado();
      setNumeroDeDoadoresCadaEstado(numeroDeDoadoresCadaEstadoResponse.data);
    };
    getPercentualObesidadeApi();
  }, [getNumeroDeDoadoresCadaEstado]);
  return (
    <div className="percentual-obesidade-por-idade">
      {numeroDeDoadoresCadaEstado.map(({ estado, numeroDeDoadores }) => (
        <div key={estado}>
          <p>{estado}</p>
          <p>{numeroDeDoadores}</p>
        </div>
      ))}
    </div>
  );
};
