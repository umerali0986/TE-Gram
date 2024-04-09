<template>
      <SiteHeader v-if="$route.path === '/' || $route.path.includes('/app')" />
  <div id="capstone-app" class="font-['Geist']">
    <router-view />
  </div>
</template>

<script>
import SiteHeader from './components/SiteHeader.vue'

  export default {
    components: {
      SiteHeader
    }
  }
</script>
