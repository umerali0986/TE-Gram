<template>
  <div
      class="flex h-full w-full justify-center py-4 px-2"
      v-if="$store.state.token"
  >
    <div
        class="container grid grid-cols-1 xl:grid-cols-2 w-full h-full gap-10"
    >

      <PostCard v-for="post in likedPosts" :key="post.id" :post="post" />
    </div>

  </div>
</template>
<script>
import postService from "@/services/PostService";

export default {
  components: {PostCard},
  data() {
    return {
      likedPosts: []
    }
  },
  methods: {
    getPosts() {
      postService.get().then(response => {
        if (response.status === 200) {
          this.$store.commit("SET_CONTENT", JSON.parse(JSON.stringify(response.data)));
          console.log("runs")
          this.likedPosts = this.$store.state.postCollection.filter((post) => post.liked)
        }
      }).catch(error => {
        console.error('Error: ', error)
      })
    }
  },
  created() {
      this.getPosts()
  }
}
import PostCard from "@/components/PostCard.vue";
</script>