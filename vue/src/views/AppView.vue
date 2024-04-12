<template>
    <div
        class="flex h-full w-full justify-center py-4"
        :class="{ 'xl:px-20 2xl:px-40' : !$store.state.isValidated, 'px-2' : $store.state.isValidated}"
    >
    <div
        class="container grid grid-cols-1 xl:grid-cols-2 w-full h-full gap-10"
    >

    <PostCard v-for="(img, index) in imageArray" :key="index" :img="img" />
    </div>

  </div>
</template>

<script>

import {defineComponent} from "vue";
import PostCard from "@/components/PostCard.vue";
import {Toaster} from "vue-sonner";

export default defineComponent({
  components: {Toaster, PostCard},
  data() {
    return {
        imageArray : this.$store.state.imageCollections
    }
  }
})
</script>