<template>
  <LoadingView/>
  <div id="capstone-app" class="font-geist">
    <router-view />
  </div>
</template>

<script>
import SiteHeader from './components/SiteHeader.vue'
import SiteFooter from "@/components/SiteFooter.vue";
import LoadingView from "@/views/LoadingView.vue";

  export default {
    components: {
      LoadingView,
      SiteHeader,
      SiteFooter
    }
  }
</script>
