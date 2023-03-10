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
    <div className="numero-doadores-cada-estado">
      {numeroDeDoadoresCadaEstado.map(({ estado, numeroDeDoadores }) => (
        <div key={estado}>
          <h5>{estado}</h5>
          <p>{numeroDeDoadores}</p>
        </div>
      ))}
    </div>
  );
};
