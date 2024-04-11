<template>
  <div class="">
    <SiteHeader/>
    <div class="flex bg-foreground/5 ">
      <Sidebar :show="true"/>
      <router-view/>
    </div>

  </div>
</template>

<script>
import SiteHeader from '@/components/SiteHeader.vue';
import Sidebar from '@/components/Sidebar.vue';

export default {
  components: {
    SiteHeader,
    Sidebar,
  },
}
</script>
