module.exports = {
    
    devServer : {
      disableHostCheck: true,
      port: 3000,
      proxy: {
        '/api': {
          target: 'http://localhost:5000',
          ws: true,
          changeOrigin: true,
          secure: false,
        },
      }
    }
  }