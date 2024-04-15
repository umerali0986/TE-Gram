<template>
    <div class="w-full h-full flex flex-col items-center container md:px-14 lg:px-32 xl:px-40">
      <div class="flex w-full gap-4 md:gap-8 lg:gap-12 xl:gap-20 pt-4">
        <div class="flex gap-2">
            <Avatar class="w-24 h-24  lg:w-32 lg:h-32">
              <AvatarImage src="https://github.com/radix-vue.png" alt="@radix-vue" />
              <AvatarFallback>CN</AvatarFallback>
            </Avatar>
        </div>

        <div class="w-full flex flex-col justify-center">
          <p class="font-medium text-2xl">{{user.username}}</p>
          <p v-if="user.name" class="opacity-80 pb-4">{{user.name}}</p>
          <div class="flex w-full justify-between">
            <div class=""><b class="font-semibold">{{userPosts.length}}</b> posts</div>
            <div class=""><b class="font-semibold">0</b> likes</div>
            <div class=""><b class="font-semibold">0</b> favorites</div>
          </div>
        </div>
      </div>

      <Separator class="mt-4"/>
      <div class="flex-1 grid grid-cols-1 pt-4 xl:grid-cols-2 w-full h-full gap-10">
        <PostCard v-for="post in userPosts" :key="post.id" :post="post"/>
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
    import {Avatar} from "@/components/ui/avatar";
    import {Separator} from "@/components/ui/separator";

    export default{

        data(){
            return {
                user: {},
                userPosts: {}
            }
        },
        components: {
          Separator,
          Avatar,
            PostCard
        },
        created(){
            userService.getUserByUsername(this.$route.params.username)
            .then(res => {
                this.user = res.data;
                console.log(this.user);
            }).catch(err => console.log(err));

            postService.getPostsByUsername(this.$route.params.username)
            .then(res => {
                this.userPosts = res.data; 
            }).catch(err => console.log(err));
        }
    }
</script>