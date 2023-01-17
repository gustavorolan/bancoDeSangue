import React from "react";
import { Link } from "react-router-dom";
import { INFOS_URL } from "../../../constant/constants";
import "./menu.css"

export const Menu = () => {
  return (
    <div className="menu">
      {INFOS_URL.map(({ url, nome }) => {
        return (
          <Link className="menu-link" key={url} to={url}>
            <div>
              <p>{nome}</p>
            </div>
          </Link>
        );
      })}
    </div>
  );
};
