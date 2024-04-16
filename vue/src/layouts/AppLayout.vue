<template>
  <div class="h-screen flex flex-col">
    <div class="h-14"><SiteHeader/></div>
    <div class="flex bg-foreground/5 h-full">
      <Sidebar :show="true"/>
<<<<<<< HEAD
      <div class="h-fit overflow-y-scroll  flex w-full justify-center">
=======
      <div class="h-fit   flex w-full justify-center">
>>>>>>> 5c3ff49ed7a502ef0fbd4db7d5f69f4b390ce0d3
        <router-view />
      </div>
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
