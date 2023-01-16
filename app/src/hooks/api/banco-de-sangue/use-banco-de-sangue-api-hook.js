import { useMemo } from "react";
import { INICIO_URL, URL_BASE, USUARIO_URL } from "../../../constant/constants";
import { useGlobalUser } from "../../../contexts/user.context";
import { useHttp } from "../_base/use-http.hook";

export function useBancoDeSangueApi() {
  const [user] = useGlobalUser();
  const httpInstance = useHttp(URL_BASE);
  const httpInstanceToken = useHttp(URL_BASE, { "x-auth-token": user.token });

  const getLogin = async ({ email, senha }) => {
    return await httpInstance.post(
      USUARIO_URL + "/login",
      {},
      {
        auth: { username: email, password: senha },
      }
    );
  };

  const criarNovoUsuario = async (usuario, senha, email) => {
    return await httpInstance.post(
      "/createNewUser",
      {},
      {
        usuario,
        senha,
        email,
      }
    );
  };

  const getUsuariosPorEstado = async () => {
    return await httpInstanceToken.get(INICIO_URL + "/getUsuariosPorEstado");
  };

  const getEstados = async () => {
    return await httpInstanceToken.get(INICIO_URL + "/estados");
  };

  const getPercentualObesidadePorSexo = async () => {
    return await httpInstanceToken.get(INICIO_URL + "/percentualObesidade");
  };

  const percentualObesidadePorIdade = async () => {
    return await httpInstanceToken.get(
      INICIO_URL + "/percentualObesidadePorIdade"
    );
  };

  const getMediaIdadePorTipoSanguineo = async () => {
    return await httpInstanceToken.get(
      INICIO_URL + "/mediaIdadePorTipoSanguineo"
    );
  };

  const getQuantidadeDeDoadoresPossiveis = async () => {
    return await httpInstanceToken.get(
      INICIO_URL + "/quantidadeDeDoadoresPossiveis"
    );
  };

  const getNumeroDeDoadoresCadaEstado = async () => {
    return await httpInstanceToken.get(
      INICIO_URL + "/estados/numeroDeDoadores"
    );
  };

  return useMemo(
    () => ({
      getLogin,
      criarNovoUsuario,
      getUsuariosPorEstado,
      getEstados,
      getPercentualObesidadePorSexo,
      getMediaIdadePorTipoSanguineo,
      percentualObesidadePorIdade,
      getQuantidadeDeDoadoresPossiveis,
      getNumeroDeDoadoresCadaEstado
    }),
    // eslint-disable-next-line react-hooks/exhaustive-deps
    []
  );
}
