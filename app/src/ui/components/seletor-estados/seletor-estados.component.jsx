import React, { useEffect, useState } from "react";
import { useBancoDeSangueApi } from "../../../hooks/api/banco-de-sangue/use-banco-de-sangue-api-hook";
import { Button } from "../index.js";

export const SeletorEstados = () => {
  const { getEstados } = useBancoDeSangueApi();
  const [listaDeEstados, setListaDeEstados] = useState([]);
  const [estado, setEstado] = useState("{}");

  useEffect(() => {
    const getEstadosApi = async () => {
      const listaDeEstadosResponse = await getEstados();
      setListaDeEstados(listaDeEstadosResponse.data);
    };
    getEstadosApi();
  }, [getEstados]);

  const handleClick = () => {
    console.log(estado);
  };

  const selecionarEstado = (sigla) => {
    setEstado(sigla);
  };

  return (
    <div className="seletor-estados">
      <select
        onClick={(Event) => selecionarEstado(Event.target.value)}
        name="estados-brasil"
      >
        {listaDeEstados.map(({ sigla }) => {
          return (
            <option key={sigla} value={sigla}>
              {sigla}
            </option>
          );
        })}
      </select>
      <Button children={"Selecionar"} onClick={() => handleClick()} />
    </div>
  );
};
