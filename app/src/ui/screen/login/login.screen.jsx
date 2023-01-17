import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useGlobalUser } from "../../../contexts/user.context";
import { useBancoDeSangueApi } from "../../../hooks/api/index.js";
import "./login.screen.css";

export function Login() {
  const [, setUser] = useGlobalUser();
  const { getLogin } = useBancoDeSangueApi();
  const navigate = useNavigate();
  const [login, setLogin] = useState({});

  const handleChange = ({ value, name }) => {
    setLogin({ ...login, [name]: value });
  };

  const handleClick = async () => {
    try {
      const response = await getLogin(login);
      setUser({ token: response.headers["x-auth-token"] });
      navigate("/menu");
    } catch (e) {
      navigate("/login")
    }
  };

  return (
    <div className="login">
      <div
        className="formContainer"
        onChange={(Event) => handleChange(Event.target)}
      >
        <h1>Banco de Sangue</h1>
        <label htmlFor="email">Email</label>
        <input type="text" name="email" />
        <label htmlFor="senha">Senha</label>
        <input type="password" name="senha" />
        <button onClick={handleClick} children={"Login"} />
      </div>
    </div>
  );
}
