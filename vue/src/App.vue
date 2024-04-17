<template>
  <LoadingView/>
  <div id="capstone-app" class="font-geist scroll-smooth bg-gradient-to-b from-background via-background to-primary/20">
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
