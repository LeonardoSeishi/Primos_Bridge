import React, { useState } from 'react';
import axios from 'axios';
import './App.css';

function App() {
    const [k, setK] = useState('');
    const [result, setResult] = useState(null);
    const [timeElapsed, setTimeElapsed] = useState(null);
    const [primes, setPrimes] = useState([]);

    const [history, setHistory] = useState([]);
    const [error, setError] = useState('');

    const handleCalculate = async () => {
        if (k && k > 0 && k < 10000) {
            try {
                const response = await axios.get(`http://localhost:8080/api/countPrimos?k=${k}`);
                const data = {
                    k: k,
                    result: response.data.quantidadePrimos,
                    primes: response.data.primos || [],
                    timeElapsed: response.data.tempoDecorrido
                };

                setHistory([...history, data]); // Adicionando ao histórico
                setResult(response.data.quantidadePrimos);
                setPrimes(response.data.primos || []);
                setTimeElapsed(response.data.tempoDecorrido);
                setError('');
            } catch (err) {
                setError('Erro ao buscar dados. Verifique se o backend está rodando.');
                console.error('Erro ao fazer a requisição:', err);
            }
        } else {
            setError('Por favor, insira um número válido.');
        }
    };

    return (
        <div className="app">
            <div className="header">
                <h1>Contador de Números Primos</h1>
            </div>
            <div className="container">
                <div className="history-panel">
                    <h2>Histórico de Consultas</h2>
                    {history.map((entry, index) => (
                        <div key={index} className="history-entry">
                            <p>Para k={entry.k}: {entry.result} primos encontrados ({entry.primes.join(', ')}). Tempo: {entry.timeElapsed} ms</p>
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
                        <button className="button" onClick={handleCalculate}>
                            Calcular
                        </button>
                    </div>
                    <div className="result-area">
                        {error && <div className="error">{error}</div>}
                        {result !== null && (
                            <div className="result">
                                <p>Quantidade de primos: {result}</p>
                                <p>Números primos: {primes.join(', ')}</p>
                                <p>Tempo de execução: {timeElapsed} ms</p>
                            </div>
                        )}
                    </div>
                </div>
            </div>
        </div>
    );
}

export default App;


