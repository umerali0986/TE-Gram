<template>
    <div
        class="flex h-full w-full justify-center py-4"
        :class="{ 'xl:px-20 2xl:px-40' : !$store.state.isValidated, 'px-2' : $store.state.isValidated}"
    >
    <div
        class="container grid grid-cols-1 xl:grid-cols-2 w-full h-full gap-10"
    >
   
    <PostCard v-for="post in $store.state.postCollection" :key="post.id" :post="post" />
    </div>
  </div>
</template>

<script>

import {defineComponent} from "vue";
import PostCard from "@/components/PostCard.vue";
import postService from '../services/PostService.js';
// import axios from "axios";

export default defineComponent({
  components: { PostCard},
  methods: {
    
    getPosts() {
      postService.get().then(response => {
        if (response.status === 200) {
          this.$store.commit("SET_CONTENT", JSON.parse(JSON.stringify(response.data)));
        }
      }).catch(error => {
        console.error('Error: ', error)
      })
    }
  },
  data() {
    return {
        imageArray : this.$store.state.imageCollections,
        postArray: []
    }
  },
  created() {
    this.getPosts()
    console.log(this.$store.state.postCollection)
  },
})
</script>