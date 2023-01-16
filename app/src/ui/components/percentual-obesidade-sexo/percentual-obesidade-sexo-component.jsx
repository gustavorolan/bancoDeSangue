import React, { useEffect, useState } from "react";
import { useBancoDeSangueApi } from "../../../hooks/api";

export const PercentualObesidadeSexo = () => {
  const { getPercentualObesidadePorSexo } = useBancoDeSangueApi();
  const [percentualObesidades, setPercentualObesidade] = useState([]);
  useEffect(() => {
    const getPercentualObesidadeApi = async () => {
      const percentualObesidadePorSexoResponse =
        await getPercentualObesidadePorSexo();
      setPercentualObesidade(percentualObesidadePorSexoResponse.data);
    };
    getPercentualObesidadeApi();
  }, [getPercentualObesidadePorSexo]);
  return (
    <div className="percentual-obesidade-por-sexo">
      {percentualObesidades.map(({ sexo, percentual }) => (
        <div key={sexo}>
          <p>{sexo}</p>
          <p>{percentual}</p>
        </div>
      ))}
    </div>
  );
};
