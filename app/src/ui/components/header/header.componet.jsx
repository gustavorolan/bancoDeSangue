import React from 'react'
import { Link } from 'react-router-dom'
import "./header.css"

export const Header = () => {
  return (
   <header className="header-container">
     <Link className="header-link" to={"/menu"}>
            Banco de Sangue
          </Link>
   </header>
  )
}
