const { defineConfig } = require('@vue/cli-service')
module.exports = {


  devServer: {
    port: 8081, 
    // proxy: {
    //   '/': {
    //     target: 'http://localhost:8080', // Spring Boot 後端地址
    //     changeOrigin: true,
    //   },
    // },
  },


}