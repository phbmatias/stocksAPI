<template>
  <NuxtLink to="/" class="back_link" title="">
    &larr; Voltar
  </NuxtLink>
  <div class="container">
    <header class="header">
      <h1>Histórico de Cotações</h1>
    </header>

    <div v-if="pending" class="feedback_loading">
      Carregando histórico...
    </div>
    <div v-if="error" class="feedback_error">
      <strong>Ocorreu um erro:</strong> {{ error.message }}
    </div>

    <div v-if="history" class="history_grid">
      <div v-for="(item, index) in history" :key="index" class="history_item">
        <h2>ID: {{ item.id }}</h2>
        <ul>
          <li><strong>Moeda:</strong> {{ item.currency }}</li>
          <li><strong>Valor em Reais:</strong> {{ item.valueInReais }}</li>
        </ul>
        <small>Pesquisa feita em: {{ item.date }}</small>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
const apiUrl = 'http://localhost:8080/all';

const { data: history, pending, error } = useLazyFetch<any[]>(apiUrl);
</script>

<style scoped>
  .container {
    width: 100%;
    max-width: 800px;
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

  .history_grid {
    margin-top: 2rem;
    display: grid;
    grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
    gap: 1.5rem;
  }

  .history_item {
    padding: 1.5rem;
    border: 1px solid #555;
    border-radius: 8px;
    background-color: #3a3a3e;
    text-align: left;
  }

  .history_item h2 {
    margin-top: 0;
    color: #54cfff;
    border-bottom: 1px solid #555;
    padding-bottom: 0.5rem;
    margin-bottom: 1rem;
  }

  .history_item ul {
    list-style-type: none;
    padding: 0;
  }

  .history_item li {
    margin-bottom: 0.75rem;
    font-size: 1.1rem;
    color: #e0e0e0;
  }

  .history_item small {
    color: #b0b0b0;
  }
</style>