<template>
  <div class="container">
    <header class="main_header">
      
      <nav class="main_nav">
        <ul>
          <li><NuxtLink to="/currency">Buscar Cotação</NuxtLink></li>
          <li><NuxtLink to="/history">Histórico</NuxtLink></li>
        </ul>
      </nav>

      <hr class="nav_divider">

      <div class="icon_link_wrapper">
        <a href="https://forms.gle/KFBjnvEr9tRZ6fry9" target="blank" class="icon_link">
          <img src="/google-forms.svg" alt="" class="icon_image">
          <span class="icon_label">Responder Formulário</span>
        </a>
      </div>
    </header>
  </div>
</template>

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
    padding: 1.5rem 2rem;
    text-align: center;
  }

  .main_header {
    width: 100%;
  }

  .main_nav ul {
    list-style-type: none;
    padding: 0;
    margin: 0;
    display: flex;
    justify-content: center;
    gap: 2rem;
  }

  .main_nav li a {
    color: #d0d0d0;
    text-decoration: none;
    font-weight: 500;
    font-size: 1.1rem;
    padding: 0.5rem 1rem;
    border-radius: 6px;
    transition: color 0.2s ease-in-out, background-color 0.2s ease-in-out;
  }

  .main_nav li a:hover {
    color: #54cfff;
    background-color: #4a4a4e;
  }

  .main_nav li a.router-link-exact-active {
    color: #54cfff;
    font-weight: bold;
    background-color: transparent;
  }

  .nav_divider {
    border: none;
    height: 1px;
    background-color: #555;
    margin: 2rem auto;
    width: 80%;
  }

  .icon_link_wrapper {
    text-align: center;
  }

  .icon_link {
    display: inline-block;
    text-decoration: none;
    color: #d0d0d0;
    transition: transform 0.2s ease-in-out, color 0.2s ease-in-out;
  }

  .icon_link:hover {
    transform: scale(1.05);
    color: #54cfff;
  }

  .icon_image {
    width: 48px;
    height: 48px;
    margin-bottom: 0.5rem;
  }

  .icon_label {
    display: block;
    font-size: 0.9rem;
    font-weight: 500;
  }
</style>