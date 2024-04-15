<template>
  <div class="h-screen flex flex-col">
    <div class="h-14"><SiteHeader/></div>
    <div class="flex bg-foreground/5 h-full overflow-y-scroll">
      <Sidebar :show="true"/>
      <div class="h-fit   flex w-full justify-center">
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
