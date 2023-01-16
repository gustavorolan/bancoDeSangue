import React, { useEffect, useState } from "react";
import { useBancoDeSangueApi } from "../../../hooks/api";

export const QuantidadeDoadoresPossiveis = () => {
  const { getQuantidadeDeDoadoresPossiveis } = useBancoDeSangueApi();
  const [quantidadeDoadoresPossiveis, setQuantidadeDoadoresPossiveis] =
    useState([]);
  useEffect(() => {
    const getPercentualObesidadeApi = async () => {
      const quantidadeDeDoadoresPossiveis =
        await getQuantidadeDeDoadoresPossiveis();
      setQuantidadeDoadoresPossiveis(quantidadeDeDoadoresPossiveis.data);
    };
    getPercentualObesidadeApi();
  }, [getQuantidadeDeDoadoresPossiveis]);
  return (
    <div className="percentual-obesidade-por-idade">
      {quantidadeDoadoresPossiveis.map(({ numeroDoadores, tipoSanguineo }) => (
        <div key={tipoSanguineo}>
          <p>{tipoSanguineo}</p>
          <p>{numeroDoadores}</p>
        </div>
      ))}
    </div>
  );
};
