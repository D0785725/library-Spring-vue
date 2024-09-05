<template>
  <div>
    <h2>Login Page</h2>
    <form @submit.prevent="login">
      <div>
        <label for="phoneNumber">Phone Number:</label>
        <input type="text" v-model="phoneNumber" required />
      </div>
      <div>
        <label for="password">Password:</label>
        <input type="password" v-model="password" required />
      </div>
      <button type="submit">Login</button>
    </form>
    <p>
      <router-link to="/register">Register a new account</router-link>
    </p>
  </div>
</template>

<script>
import { ref } from 'vue';

export default {
  name: 'LoginPage',
  setup() {
    const phoneNumber = ref('');
    const password = ref('');

    const login = async () => {
      try {
        const response = await fetch('/login', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
          },
          body: new URLSearchParams({
            username: phoneNumber.value,
            password: password.value,
          }),
        });

        if (response.ok) {
          const token = await response.text(); // 假設後端返回的 token 作為文本
          localStorage.setItem('token', token); // 保存 token 到 localStorage
          window.location.href = '/home'; // 登入成功後跳轉到首頁
        } else {
          alert('Login failed');
        }
      } catch (error) {
        console.error('Error:', error);
      }
    };

    return { phoneNumber, password, login };
  },
};
</script>