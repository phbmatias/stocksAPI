<template>
  <NuxtLink to="/" class="back_link" title="">
  &larr; Voltar
  </NuxtLink>
  <div class="container">
    <header class="header">
      <h1>StocksAPI</h1>
      <p>Selecione uma moeda para ver a cotação atualizada</p>
    </header>

    <div class="selector">
      <label for="coin-select">Escolha a moeda:</label>
      <select id="coin-select" v-model="selectedCoin">
        <option value="usd">Dólar</option>
        <option value="eur">Euro</option>
        <option value="btc">Bitcoin</option>
      </select>
    </div>
    
    <div v-if="res" class="result_card">
        <h2>{{ res.currency }}</h2>
        <ul>
            <li><strong>Valor em Reais:</strong> {{ res.valueInReais }}</li>
        </ul>
        <small>Pesquisa feita em: {{ res.date }}</small>
    </div>

    <div v-if="error" class="feedback_error">
      <strong>Ocorreu um erro:</strong> {{ error.statusMessage }}
    </div>
  </div>
</template>

<script setup lang="ts">
import { useLazyFetch } from 'nuxt/app';
import { ref, computed } from 'vue';

const selectedCoin = ref('');

const apiUrl = computed(() => `http://localhost:8080/${selectedCoin.value}`);

const { data: res, error } = useLazyFetch(apiUrl, {

  transform: (response: any) => {
    if (!response) return null;
    const key = Object.keys(response)[0];
    if (!key) {
        return null
    }
    return response[key];
  },

  watch: [selectedCoin]
});
</script>

<style>
  body {
    font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
    background: #1a1a1c;
    color: #e0e0e0;
    display: flex;
    justify-content: center;
    align-items: flex-start;
    min-height: 100vh;
    padding-top: 40px;
  }

  .container {
    width: 100%;
    max-width: 600px;
    background-color: #333338;
    border-radius: 12px;
    box-shadow: 0 8px 24px rgba(0, 0, 0, 0.4);
    padding: 2rem;
    text-align: center;
  }

  .header h1 {
    margin-top: 0;
    color: #54cfff;
  }

  .back_link {
    position: fixed;
    top: 20px;
    left: 20px;
    z-index: 1000;
    color: #d0d0d0;
    text-decoration: none;
    font-weight: 500;
    font-size: 1rem;
    padding: 0.5rem 1rem;
    border: 1px solid #555;
    border-radius: 8px;
    background-color: #3a3a3e;
    transition: background-color 0.2s, color 0.2s;
  }

  .back_link:hover {
    background-color: #4a4a4e;
    color: #ffffff;
  }

  .selector {
    margin: 2rem 0;
  }

  .selector label {
    margin-right: 1rem;
    font-weight: 500;
    color: #d0d0d0;
  }

  .selector select {
    padding: 0.5rem 1rem;
    font-size: 1rem;
    border-radius: 6px;
    border: 1px solid #555;
    background-color: #444;
    color: #f0f0f0;
  }

  .feedback {
    padding: 1rem;
    border-radius: 8px;
    margin-top: 1.5rem;
  }

  .loading {
    background-color: #4a4a4e;
    color: #c0c0c0;
  }

  .error {
    background-color: #8b0000;
    color: #ffcdd2;
  }

  .result_card {
    margin-top: 1.5rem;
    padding: 1.5rem;
    border: 1px solid #555;
    border-radius: 8px;
    background-color: #3a3a3e;
    text-align: left;
  }

  .result_card h2 {
    margin-top: 0;
    color: #54cfff;
    border-bottom: 1px solid #555;
    padding-bottom: 0.5rem;
    margin-bottom: 1rem;
  }

  .result_card ul {
    list-style-type: none;
    padding: 0;
  }

  .result_card li {
    margin-bottom: 0.75rem;
    font-size: 1.1rem;
    color: #e0e0e0;
  }

  .result_card small {
    color: #b0b0b0;
  }
</style>