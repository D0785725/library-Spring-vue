<template>
    <div>
      <h2>Home Page</h2>
      <p>Welcome to the Home Page</p>
      <button @click="logout">Logout</button>
    </div>
  </template>
  
  <script>
  export default {
    name: 'HomePage',
    methods: {
      logout() {
        fetch('/logout', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
          },
        }).then(() => {
          localStorage.removeItem('token'); // 移除 token
          window.location.href = '/'; // 登出後跳轉到登入頁面
        }).catch(error => {
          console.error('Logout failed:', error);
        });
      },
    },
  };
  </script>
  
  <style scoped>
  h2 {
    color: #333;
  }
  
  button {
    margin-top: 20px;
    padding: 10px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }
  
  button:hover {
    background-color: #0056b3;
  }
  </style>