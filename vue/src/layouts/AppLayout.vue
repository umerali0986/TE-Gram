<template>
  <div class="h-screen flex flex-col relative">
    <div class="h-14 bg-background"><SiteHeader/></div>
    <div class="flex bg-muted h-full overflow-y-scroll">
      <Sidebar :show="true"/>
      <div class="h-fit flex overflow-scroll w-full justify-center no-scrollbar">
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
