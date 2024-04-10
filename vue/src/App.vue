<template>
  <LoadingView/>
  <div id="capstone-app" class="font-geist scroll-smooth">
    <router-view />
  </div>
</template>

<script>
import LoadingView from "@/views/LoadingView.vue";

  export default {
    components: {
      LoadingView,
    }
  }
</script>
