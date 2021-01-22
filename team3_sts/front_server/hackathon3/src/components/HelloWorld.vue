<template>
  <div class="hello">

    <!-- <button type="button">보기</button> -->
    {{ name }} <br>
    <button type="button" @click="search">보기</button>
    <div v-if='view === true'>
      -------------------<br>
      {{ name2 }}
    </div>


  </div>
    
</template>

<script>
import axios from 'axios'

export default {
  name: "HelloWorld",
  props: {
    msg: String
  },
  data(){
    return{
      view: false,
      name: '',
      name2: ''
    }
  },
  created() {
    axios.get('/api/stocks/kospi/lists')
      .then(res => {
        this.name = res.data;
        // this.view = true;
      })
      .catch(err => {
        console.log('err', err);
      })

    // axios.get('http://127.0.0.1:5000/api/test')
    //   .then(res => {
    //     this.name = res.data.message;
    //     // this.view = true;
    //   })
    //   .catch(err => {
    //     console.log('err', err);
    //   })
  },

  methods: {
    search() {
      axios.get('/api/test')
      .then(res => {
        this.name2 = res.data.message;
        this.view = true;
      })
      .catch(err => {
        console.log('err', err);
      })
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
