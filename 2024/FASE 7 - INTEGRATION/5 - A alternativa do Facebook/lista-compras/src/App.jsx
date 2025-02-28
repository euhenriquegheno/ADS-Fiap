import { useState } from 'react';
import Formulario from './components/Formulario';
import Produto from './components/Produto';

function App() {

  const [produto, setProduto] = useState({'nome':'', 'preco':'', 'quantidade':''})
  const [lista, setLista] = useState([])
  const [total, setTotal] = useState(0)

  function totalCompra(){
  }


  function adicionar(e){
    e.preventDefault()
    setLista([...lista, produto])
    setTotal(total + (produto.preco * produto.quantidade))
    setProduto({'nome':'', 'preco':'', 'quantidade':''})
  }

  function captar(e){
    setProduto({...produto, [e.target.name]:e.target.value})
  }

  function deletar(p){
    setTotal(total - (p.preco * p.quantidade))
    let listaNova = lista.filter((pro)=> pro !== p)
    setLista(listaNova)
  }

  return (
    <div className="App">
      <h2>Lista de Compras</h2>
      <fieldset>
        <legend>Adicionar Produto</legend>
        <Formulario produto={produto} adicionar={adicionar} captar={captar}/>
      </fieldset>
      <br/>
      <table border="1" cellPadding={0}>
        <thead>
          <tr>
            <th>Nome</th>
            <th>Preço</th>
            <th>Quantidade</th>
            <th>SubTotal</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
        {
          lista.map((p,i)=>(
            <Produto key={i}
              nome={p.nome}
              preco={p.preco}
              quantidade={p.quantidade}
              deletar={deletar.bind(this,p)}
            />
          ))
        }
        </tbody>
      </table>
      <p>Total:{total.toFixed(2)}</p>
    </div>
  );
}

export default App;