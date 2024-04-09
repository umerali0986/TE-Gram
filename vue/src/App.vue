<template>
      <SiteHeader v-if="$route.path === '/' || $route.path === '/app'" />
  <div id="capstone-app" class="font-['Geist']">
    <router-view />
  </div>
</template>

<script>
import SiteHeader from './components/SiteHeader.vue'

  export default {
    components: {
<<<<<<< HEAD
      
=======
      SiteHeader
>>>>>>> 84ee13d4b6f7776f4d4df4fdd751b2e5f9b80aa0
    }
  }
</script>
