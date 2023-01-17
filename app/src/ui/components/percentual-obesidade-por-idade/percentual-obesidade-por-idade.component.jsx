import React, { useEffect, useState } from "react";
import { useBancoDeSangueApi } from "../../../hooks/api";

export const PercentualObesidadePorIdade = () => {
  const { percentualObesidadePorIdade } = useBancoDeSangueApi();
  const [percentualObesidades, setPercentualObesidade] = useState([]);
  useEffect(() => {
    const getPercentualObesidadeApi = async () => {
      const percentualObesidadePorIdadeResponse =
        await percentualObesidadePorIdade();
      setPercentualObesidade(percentualObesidadePorIdadeResponse.data);
    };
    getPercentualObesidadeApi();
  }, [percentualObesidadePorIdade]);
  return (
    <div className="percentual-obesidade-por-idade">
      {percentualObesidades.map(({ faixaEtaria, media }) => (
        <div key={faixaEtaria}>
          <p>{faixaEtaria}</p>
          <p>{parseFloat(media).toFixed(1)}%</p>
        </div>
      ))}
    </div>
  );
};
