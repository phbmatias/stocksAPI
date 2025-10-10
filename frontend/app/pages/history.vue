<template>
  <div class="container">
    <header class="header">
      <h1>Histórico de Cotações</h1>
    </header>

    <div v-if="pending" class="feedback loading">
      Carregando histórico...
    </div>
    <div v-if="error" class="feedback error">
      <strong>Ocorreu um erro:</strong> {{ error.message }}
    </div>

    <div v-if="history" class="history-grid">
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
// URL do novo endpoint que retorna a lista completa
const apiUrl = 'http://localhost:8080/all';

// useFetch para buscar a lista de dados.
const { data: history, pending, error } = useLazyFetch<any[]>(apiUrl);
</script>

<style scoped>
/* Estilos herdados da sua página original para consistência */
.container {
  width: 100%;
  max-width: 800px; /* Um pouco maior para a lista */
  background-color: #333338;
  border-radius: 12px;
  box-shadow: 0 8px 24px rgba(0, 0, 0, 0.4);
  padding: 2rem;
  text-align: center;
}

.header h1 {
  margin-top: 0;
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

/* Novo estilo para o grid da lista */
.history-grid {
  margin-top: 2rem;
  display: grid;
  /* Cria colunas responsivas */
  grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
  gap: 1.5rem;
}

/* Estilo para cada item da lista (baseado no .result_card) */
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