<template>
  <div>
    <SiteHeader/>
    <router-view/>
    <SiteFooter v-if="$route.path === '/'" />
  </div>
</template>

<script setup lang="ts">
import SiteHeader from "@/components/SiteHeader.vue";
import SiteFooter from "@/components/SiteFooter.vue";
</script>