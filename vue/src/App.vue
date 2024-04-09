<template>
  
      <Navbar />
  <div id="capstone-app" class="font-['Geist']">
    <router-view />
  </div>
</template>

<script>
import Navbar from './components/SiteHeader.vue'
import SiteFooter from "./components/SiteFooter.vue";
  export default {
    components: {
      
    }
  }
</script>
