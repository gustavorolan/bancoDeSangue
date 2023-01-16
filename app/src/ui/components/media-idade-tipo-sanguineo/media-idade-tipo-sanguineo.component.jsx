import React, { useEffect, useState } from "react";
import { useBancoDeSangueApi } from "../../../hooks/api";

export const MediaIdadeTipoSanguineo = () => {
  const { getMediaIdadePorTipoSanguineo } = useBancoDeSangueApi();
  const [mediaIdadePorTipoSanguineo, setmediaIdadePorTipoSanguineo] = useState(
    []
  );
  useEffect(() => {
    const getMediaIdadePorTipoSanguineoApi = async () => {
      const mediaIdadePorTipoSanguineoResponse =
        await getMediaIdadePorTipoSanguineo();
      setmediaIdadePorTipoSanguineo(mediaIdadePorTipoSanguineoResponse.data);
    };
    getMediaIdadePorTipoSanguineoApi();
  }, [getMediaIdadePorTipoSanguineo]);
  return (
    <div>
      {mediaIdadePorTipoSanguineo.map(({ tipoSanguineo, media }) => (
        <div key={tipoSanguineo}>
          <p>{tipoSanguineo}</p>
          <p>{media}</p>
        </div>
      ))}
    </div>
  );
};
