function CompEvento(props) {
  return(
    <div>
      <button onClick={props.funcao}>{props.texto}</button>
    </div>
  )
}

export default CompEvento;