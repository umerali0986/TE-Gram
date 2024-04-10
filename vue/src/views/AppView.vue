<template>
    <div class="flex h-full w-full justify-center py-4 px-2">
    <div
        class="container grid grid-cols-1 xl:grid-cols-2 w-full h-full gap-10"
        :class="{ '' : $store.state.isValidated}"
    >

    <PostCard v-for="(img, index) in imageArray" :key="index" :img="img" />
    </div>
  </div>
</template>

<script>

import {defineComponent} from "vue";
import PostCard from "@/components/PostCard.vue";

export default defineComponent({
  components: {PostCard},
  data() {
    return {
        imageArray : this.$store.state.imageCollections
    }
  }
})
</script>