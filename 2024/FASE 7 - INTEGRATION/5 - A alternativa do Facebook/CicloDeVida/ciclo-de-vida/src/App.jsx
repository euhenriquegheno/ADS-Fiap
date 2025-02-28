import { useState } from "react";
import Comp from "./components/Comp";
import CompFunction from "./components/CompFunction";
import CompEvento from "./components/CompEvento";

export default function App() {

  const [componente, setComponente] = useState(false);

  function acaoDoBotaoEvento() {
    alert('Evento disparado');
  }

  return(
    <>
      <h1>Ciclo de vida</h1>
      
      {/* Se o componente n existe, cria, senao nao */}
      {componente ? <Comp/> : ""} 
      <button onClick={()=>setComponente(!componente)}>
        {componente ? "Desmontar" : "Montar"}
      </button>
      
      <CompFunction/>

      <CompEvento texto='Clique aqui' funcao={acaoDoBotaoEvento}/>

    </>
  )
}