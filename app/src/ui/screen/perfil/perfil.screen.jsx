import React, { useEffect, useState } from "react";
import { useBancoDeSangueApi } from "../../../hooks/api";
import "./perfil.css";

export const Perfil = () => {
  const { getUsuarioAutenticado } = useBancoDeSangueApi();
  const [usuario, setUsuario] = useState({});
  useEffect(() => {
    const getUsuarioAutenticadoApi = async () => {
      const usuarioResponse = await getUsuarioAutenticado();
      setUsuario(usuarioResponse.data);
      console.log(usuario);
    };
    getUsuarioAutenticadoApi();
  }, [getUsuarioAutenticado]);

  return (
    <div className="perfil">
      <div>
        <h1>Minhas Informações</h1>
        <p>Nome</p>
        <span>{usuario?.nome}</span>
        <p>Email</p>
        <span>{usuario?.email}</span>
        <p>Celular</p>
        <span>{usuario?.contato?.celular}</span>
        <p>Cidade</p>
        <span>{usuario?.enderecoResponse?.cidade}</span>
        <p>Estado </p>
        <span>{usuario?.enderecoResponse?.estado}</span>
        <p>Sexo: <span>{usuario?.informacoesPessoaisResponse?.sexo}</span></p>
        <p>
          Tipo Sanguineo: <span>{usuario?.informacoesPessoaisResponse?.tipoSanguineo}</span>
        </p>
        <p>Permitdo Doar: <span>{usuario?.permitidoDoar?"Sim":"Não"}</span></p>
      </div>
    </div>
  );
};
