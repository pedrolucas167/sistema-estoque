import React, { useEffect, useState } from 'react';
import axios from 'axios';

function App() {
  const [produtos, setProdutos] = useState([]);
  const [nome, setNome] = useState('');
  const [quantidade, setQuantidade] = useState('');

  const fetchProdutos = async () => {
    const res = await axios.get('http://localhost:8080/produtos');
    setProdutos(res.data);
  };

  const adicionarProduto = async () => {
    await axios.post('http://localhost:8080/produtos', { nome, quantidade });
    setNome('');
    setQuantidade('');
    fetchProdutos();
  };

  const deletarProduto = async (id) => {
    await axios.delete(`http://localhost:8080/produtos/${id}`);
    fetchProdutos();
  };

  useEffect(() => {
    fetchProdutos();
  }, []);

  return (
    <div style={{ padding: 20 }}>
      <h1>Estoque</h1>
      <input placeholder="Nome" value={nome} onChange={e => setNome(e.target.value)} />
      <input type="number" placeholder="Quantidade" value={quantidade} onChange={e => setQuantidade(e.target.value)} />
      <button onClick={adicionarProduto}>Adicionar</button>
      <ul>
        {produtos.map(p => (
          <li key={p.id}>
            {p.nome} - {p.quantidade}
            <button onClick={() => deletarProduto(p.id)}>Remover</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
