import React, { useState } from 'react';    // hook useState para fazer o genrenciamento de estado
import axios from 'axios';                  // axios para fazer chamadas HTTO
import './App.css';

function App() {
    // estados para armazenar os dados recebidos do usuario ou resultados dos calculos de numeros primos
    const [k, setK] = useState('');
    const [resultado, setResultado] = useState(null);
    const [tempoTotal, setTempoTotal] = useState(null);
    const [primos, setPrimos] = useState([]);

    const [historico, setHistorico] = useState([]);
    const [erro, setErro] = useState('');

    // funcao chamada quando o usuario clicar no botao 'Calcular'
    const calcularPrimos = async () => {
        if (k && k > 0 && k <= 99999) { // verificacao se o numero 'k' e valido
            try {
                // faz uma chamada GET para o back-end
                const resposta = await axios.get(`http://localhost:8080/api/countPrimos?k=${k}`);
                // extracao dos dados relevantes da resposta
                const dados = {
                    k: k,
                    resultado: resposta.data.quantidadePrimos,
                    primos: resposta.data.primos || [],
                    tempoTotal: resposta.data.tempoTotal
                };
                // atualizacao dos estados com os dados recebidos e adicao ao historico
                setHistorico([...historico, dados]);
                setResultado(resposta.data.quantidadePrimos);
                setPrimos(resposta.data.primos || []);
                setTempoTotal(resposta.data.tempoTotal);
                setErro('');

            } catch (err) {
                setErro('Erro ao buscar dados. Verifique se o backend está rodando.');
                console.error('Erro ao fazer a requisição:', err);
            }
        } else {
            setErro('Por favor, insira um número válido.');
        }
    };
    // JSX que define a estrutura do componente na pagina web
    return (
        <div className="app">
            <div className="header">
                <h1>Contador de Números Primos</h1>
            </div>
            <div className="container">
                <div className="history-panel">
                    <h2>Histórico de Consultas</h2>
                    {historico.map((entrada, indice) => (
                        <div key={indice} className="history-entry">
                            <p>Para k={entrada.k}: {entrada.resultado} primos encontrados ({entrada.primos.join(', ')}). Tempo: {entrada.tempoTotal} ms</p>
                        </div>
                    ))}
                </div>
                <div className="input-result-panel">
                    <div className="input-area">
                        <input
                            className="input"
                            type="number"
                            value={k}
                            onChange={e => setK(e.target.value)}
                            placeholder="Digite um número"
                        />
                        <button className="button" onClick={calcularPrimos}>
                            Calcular
                        </button>
                    </div>
                    <div className="result-area">
                        {erro && <div className="error">{erro}</div>}
                        {resultado !== null && (
                            <div className="result">
                                <p>Quantidade de primos: {resultado}</p>
                                <p>Números primos: {primos.join(', ')}</p>
                                <p>Tempo de execução: {tempoTotal} ms</p>
                            </div>
                        )}
                    </div>
                </div>
            </div>
        </div>
    );
}

export default App;