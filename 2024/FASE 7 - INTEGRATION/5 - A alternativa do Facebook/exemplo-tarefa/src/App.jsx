import { useState } from "react"

export default function App() {

  const [tarefa, setTarefa] = useState("");
  const [todas, setTodas] = useState([]);

  function incluirTarefa() {
    //Com os ... pega apenas o conteudo de "todas" e coloca dentro do Array
    setTodas([...todas, tarefa]);
  }

  return(
    <>
      <h1>Exemplo React</h1>
      <textarea name="tarefa" onChange={(e)=> setTarefa(e.target.value)} value={tarefa} ></textarea>
      <br />
      <button onClick={incluirTarefa}>Incluir</button>
      
      <ul>
        {todas.map((tar, i)=>(
          <li key={i} >{tar}</li>
        ))}
      </ul>
    </>
  )

}