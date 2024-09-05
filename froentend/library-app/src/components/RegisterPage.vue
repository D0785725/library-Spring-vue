<template>
  <div>
    <h2>Register Page</h2>
    <form @submit.prevent="register">
      <div>
        <label for="userName">Username:</label>
        <input type="text" v-model="userName" required />
      </div>
      <div>
        <label for="phoneNumber">Phone Number:</label>
        <input type="text" v-model="phoneNumber" required />
      </div>
      <div>
        <label for="password">Password:</label>
        <input type="password" v-model="password" required />
      </div>
      <button type="submit">Register</button>
    </form>
  </div>
</template>

<script>
import { ref } from 'vue';

export default {
  name: 'RegisterPage',
  setup() {
    const userName = ref('');
    const phoneNumber = ref('');
    const password = ref('');

    const register = async () => {
      try {
        const response = await fetch('/users/register', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify({
            userName: userName.value,
            phoneNumber: phoneNumber.value,
            password: password.value,
          }),
        });

        if (response.ok) {
          alert('Registration successful');
          window.location.href = '/'; // 註冊成功後跳轉到登入頁面
        } else {
          alert('Registration failed');
        }
      } catch (error) {
        console.error('Error:', error);
      }
    };

    return { userName, phoneNumber, password, register };
  },
};
</script>