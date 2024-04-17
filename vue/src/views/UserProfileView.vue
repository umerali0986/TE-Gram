<template>
  <div class="w-full h-full flex flex-col items-center container md:px-14 lg:px-32 xl:px-40">
    <div class="flex w-full gap-4 md:gap-8 lg:gap-12 xl:gap-20 pt-4">
      <div class="flex gap-2">
        <Avatar class="w-24 h-24  lg:w-32 lg:h-32 bg-muted-foreground/30">
          <AvatarImage :src="`http://localhost:9000/users/${user.username}/image`" alt="" />
          <AvatarFallback>{{user.username.charAt(0).toUpperCase()}}</AvatarFallback>
        </Avatar>
      </div>

      <div class="w-full flex flex-col justify-center">
        <p class="font-medium text-2xl">{{ user.username }}</p>
        <p v-if="user.name" class="opacity-80 pb-4">{{ user.name }}</p>
        <div class="flex w-full justify-between">
          <div class="text-xl"><b class="font-semibold">{{ getTotalPosts || 0 }}</b> posts</div>
          <div class="text-xl"><b class="font-semibold">{{ getTotalUserLikes}}</b> likes</div>
          <div class="text-xl"><b class="font-semibold ">{{ getTotalUserFavorite }}</b> favorites</div>
        </div>
      </div>
    </div>

    <Separator class="mt-4" />
    <div class="flex-1 grid grid-cols-1 pt-4 xl:grid-cols-2 w-full h-full gap-10">
      <PostCard v-for="(post,index) in $store.state.postCollection" :key="index" :post="post" @toggleChange="receiveEmit" />
    </div>




    <!--        <h1>This is {{ user.username }}'s profile!</h1>-->
    <!--        <div v-if="userPosts[0] !== ''">-->
    <!--            These are {{ user.username }}'s photos! -->
    <!--            <PostCard v-for="(post, index) in userPosts" :key="index" :post="post"></PostCard>-->
    <!--        </div>-->
  </div>
</template>

<script>
import userService from '@/services/UserService';
import postService from '../services/PostService';
import PostCard from '@/components/PostCard.vue';
import axios from 'axios';
import {Avatar, AvatarFallback, AvatarImage} from "@/components/ui/avatar";
import { Separator } from "@/components/ui/separator";

export default {

  data() {
    return {
      user: {},
      
    }
  },
  methods: {
    receiveEmit(){
      this.$router.go();
    },
  },
  components: {
    Separator,
    Avatar,
    PostCard,
    AvatarImage,
    AvatarFallback
  },
  computed: {

    getTotalUserLikes() {

      let totalLikes = 0;
      if(this.$store.state.postCollection){
      this.$store.state.postCollection.forEach(post => {
        totalLikes += post.totalLikes
      });
    }

      return totalLikes;
    },

    getTotalUserFavorite() {

      let totalFavorites = 0;
      if(this.$store.state.postCollection){
      this.$store.state.postCollection.forEach(post => {
        totalFavorites += post.totalFavorites
      });
    }
      return totalFavorites;
    },
    
  getTotalPosts(){
    let totalPosts = 0;
    if(this.$store.state.postCollection !== null){
      totalPosts = this.$store.state.postCollection.length;
  }
  return totalPosts;
  }
}
  ,
  created() {
    userService.getUserByUsername(this.$route.params.username)
      .then(res => {
        this.user = res.data;
      }).catch(err => console.log(err));

    postService.getPostsByUsername(this.$route.params.username)
      .then(res => {
        this.$store.commit("SET_CONTENT", JSON.parse(JSON.stringify(res.data)));
        
     
      }).catch(err => console.log(err));
  }
}
</script>