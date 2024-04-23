import React, { useState } from 'react';
import axios from 'axios';
import './App.css';

function App() {
    const [k, setK] = useState('');
    const [result, setResult] = useState(null);
    const [timeElapsed, setTimeElapsed] = useState(null);
    const [error, setError] = useState('');

    const handleCalculate = async () => {
        if (k) {
            try {
                const response = await axios.get(`http://localhost:8080/api/countPrimos?k=${k}`);
                console.log('Resposta completa:', response);  // Logar a resposta completa
                console.log('Dados recebidos:', response.data);  // Logar apenas os dados
                setResult(response.data.quantidadePrimos);
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
        <div className="App">
            <header className="App-header">
                <h1>Contador de Números Primos</h1>
                <input
                    type="number"
                    value={k}
                    onChange={e => setK(e.target.value)}
                    placeholder="Digite um número"
                />
                <button onClick={handleCalculate}>
                    Calcular
                </button>
                {result !== null && (
                    <div>
                        <p>Quantidade de primos: {result}</p>
                        <p>Tempo de execução: {timeElapsed} ms</p>
                    </div>
                )}
                {error && <p className="error">{error}</p>}
            </header>
        </div>
    );
}

export default App;