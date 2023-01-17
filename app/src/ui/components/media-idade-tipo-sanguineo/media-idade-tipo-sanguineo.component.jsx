import React, { useEffect, useState } from "react";
import { useBancoDeSangueApi } from "../../../hooks/api";

export const MediaIdadeTipoSanguineo = () => {
  const { getMediaIdadePorTipoSanguineo } = useBancoDeSangueApi();
  const [mediaIdadePorTipoSanguineo, setmediaIdadePorTipoSanguineo] = useState(
    []
  );
 
  useEffect(() => {
    const getMediaIdadePorTipoSanguineoApi = async () => {
      const mediaIdadePorTipoSanguineoResponse = await getMediaIdadePorTipoSanguineo();
      setmediaIdadePorTipoSanguineo(mediaIdadePorTipoSanguineoResponse.data);
    };
    getMediaIdadePorTipoSanguineoApi();
  }, [getMediaIdadePorTipoSanguineo]);

  useEffect(() => {
    setmediaIdadePorTipoSanguineo(mediaIdadePorTipoSanguineo);
  }, [mediaIdadePorTipoSanguineo,setmediaIdadePorTipoSanguineo,getMediaIdadePorTipoSanguineo]);


  return (
    <div className="media-idade-por-tipo-sanguineo">
      {mediaIdadePorTipoSanguineo.map(({ tipoSanguineo, media }) => (
        <div key={tipoSanguineo}>
          <p>{tipoSanguineo}</p>
          <p>{media}</p>
        </div>
      ))}
    </div>
  );
};
