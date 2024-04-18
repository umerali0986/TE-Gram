<template>
    <div  class="no-scrollbar flex w-full container px-4 pt-5 flex-wrap lg:flex-nowrap overflow-y-scroll">
      <Toaster />
        <div class="flex-[2] aspect-square min-w-[28rem] lg:max-w-[20rem] xl:max-w-[48.5rem]">
            <img class="w-full aspect-square rounded-lg" :alt="post.image.altDesc || ''" :src="`http://localhost:9000/posts/${post.id}/image`">
        </div>

        <div class="flex-[1] min-w-[20rem] lg:min-w-fit lg:px-8 pt-8">
            <div class="flex flex-col">
              <div class="flex w-full pb-4">
                <div class="flex gap-2">
                  <router-link :to="`/app/profile/${$store.state.user.username}`">
                    <Avatar class="h-14 w-14">
                      <AvatarImage :src="`http://localhost:9000/users/${post.postCreator}/image`" alt="@radix-vue" />
                      <AvatarFallback>{{post.postCreator.charAt(0).toUpperCase()}}</AvatarFallback>
                    </Avatar>
                  </router-link>

                  <div class="flex flex-col gap-0 justify-center">
                    <h5 class="font-semibold text-lg leading-[1rem]">{{ post.postCreator }}</h5>
                    <p class="text-base text-muted-foreground">{{post.caption}}</p>
                    <p class="text-sm leading-none">{{ moment(post.createdOn).utc().local().fromNow()  }}</p>
                  </div>
                </div>
              </div>

              <Separator class="bg-foreground/20"/>
            </div>

          <div class="flex-1 w-full h-[33.5rem]  py-4 px-4 overflow-y-scroll gap-4 flex flex-col no-scrollbar">
            <CommentCard v-for="(commentInfo, index) in post.comments" :key="index" :commentInfo="commentInfo"/>
            <!-- <div class="w-full">
              <div class="flex gap-2">
                <Avatar>
                  <AvatarImage src="https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg" alt="@radix-vue" />
                  <AvatarFallback>CN</AvatarFallback>
                </Avatar>

                <div class="flex flex-col gap-0 justify-center">
                  <div class="flex-">
                    <p class=""><b class="font-semibold inline-flex leading-[1rem]">shadcn</b> Does that mean we’ll get lots more colour options in tables soon 🙏That would be incredible 🙂</p>
                  </div>
                  <p class="text-sm font-medium opacity-50">9 hrs ago</p>
                </div>
              </div>
            </div>

            <div class="w-full">
              <div class="flex gap-2">
                <Avatar>
                  <AvatarImage src="https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg" alt="@radix-vue" />
                  <AvatarFallback>CN</AvatarFallback>
                </Avatar>

                <div class="flex flex-col gap-0 justify-center">
                  <div class="flex-">
                    <p class=""><b class="font-semibold inline-flex leading-[1rem]">shadcn</b> Does that mean we’ll get lots more colour options in tables soon 🙏That would be incredible 🙂</p>
                  </div>
                  <p class="text-sm font-medium opacity-50">9 hrs ago</p>
                </div>
              </div>
            </div>

            <div class="w-full">
              <div class="flex gap-2">
                <Avatar>
                  <AvatarImage src="https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg" alt="@radix-vue" />
                  <AvatarFallback>CN</AvatarFallback>
                </Avatar>

                <div class="flex flex-col gap-0 justify-center">
                  <div class="flex-">
                    <p class=""><b class="font-semibold inline-flex leading-[1rem]">shadcn</b> Does that mean we’ll get lots more colour options in tables soon 🙏That would be incredible 🙂</p>
                  </div>
                  <p class="text-sm font-medium opacity-50">9 hrs ago</p>
                </div>
              </div>
            </div>

            <div class="w-full">
              <div class="flex gap-2">
                <Avatar>
                  <AvatarImage src="https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg" alt="@radix-vue" />
                  <AvatarFallback>CN</AvatarFallback>
                </Avatar>

                <div class="flex flex-col gap-0 justify-center">
                  <div class="flex-">
                    <p class=""><b class="font-semibold inline-flex leading-[1rem]">shadcn</b> Does that mean we’ll get lots more colour options in tables soon 🙏That would be incredible 🙂</p>
                  </div>
                  <p class="text-sm font-medium opacity-50">9 hrs ago</p>
                </div>
              </div>
            </div>

            <div class="w-full">
              <div class="flex gap-2">
                <Avatar>
                  <AvatarImage src="https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg" alt="@radix-vue" />
                  <AvatarFallback>CN</AvatarFallback>
                </Avatar>

                <div class="flex flex-col gap-0 justify-center">
                  <div class="flex-">
                    <p class=""><b class="font-semibold inline-flex leading-[1rem]">shadcn</b> Does that mean we’ll get lots more colour options in tables soon 🙏That would be incredible 🙂</p>
                  </div>
                  <p class="text-sm font-medium opacity-50">9 hrs ago</p>
                </div>
              </div>
            </div>

            <div class="w-full">
              <div class="flex gap-2">
                <Avatar>
                  <AvatarImage src="https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg" alt="@radix-vue" />
                  <AvatarFallback>CN</AvatarFallback>
                </Avatar>

                <div class="flex flex-col gap-0 justify-center">
                  <div class="flex-">
                    <p class=""><b class="font-semibold inline-flex leading-[1rem]">shadcn</b> Does that mean we’ll get lots more colour options in tables soon 🙏That would be incredible 🙂</p>
                  </div>
                  <p class="text-sm font-medium opacity-50">9 hrs ago</p>
                </div>
              </div>
            </div>

            <div class="w-full">
              <div class="flex gap-2">
                <Avatar>
                  <AvatarImage src="https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg" alt="@radix-vue" />
                  <AvatarFallback>CN</AvatarFallback>
                </Avatar>

                <div class="flex flex-col gap-0 justify-center">
                  <div class="flex-">
                    <p class=""><b class="font-semibold inline-flex leading-[1rem]">shadcn</b> Does that mean we’ll get lots more colour options in tables soon 🙏That would be incredible 🙂</p>
                  </div>
                  <p class="text-sm font-medium opacity-50">9 hrs ago</p>
                </div>
              </div>
            </div> -->
          </div>


          <div class="h-52 mb-2 w-full flex flex-col gap-3 pt-2">
              <div class="flex w-full justify-between">
                <div class="flex gap-2 items-center">
                 <button @click="handleLike">
                  <svg class="text-foreground" width="24" height="24" viewBox="0 0 24 24" :fill="post.liked ? 'currentColor' : 'none'" xmlns="http://www.w3.org/2000/svg">
                    <rect width="24" height="24" fill="none"/>
                    <path d="M20.4201 4.58002C19.9184 4.07659 19.3223 3.67716 18.6659 3.40461C18.0095 3.13206 17.3058 2.99176 16.5951 2.99176C15.8844 2.99176 15.1806 3.13206 14.5243 3.40461C13.8679 3.67716 13.2718 4.07659 12.7701 4.58002L12.0001 5.36002L11.2301 4.58002C10.7284 4.07659 10.1323 3.67716 9.47591 3.40461C8.81953 3.13206 8.1158 2.99176 7.40509 2.99176C6.69437 2.99176 5.99065 3.13206 5.33427 3.40461C4.67789 3.67716 4.08176 4.07659 3.58009 4.58002C1.46009 6.70002 1.33009 10.28 4.00009 13L12.0001 21L20.0001 13C22.6701 10.28 22.5401 6.70002 20.4201 4.58002Z" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                  </svg>
                </button>

                  <span class="text-foreground text-sm font-normal leading-tight">{{ post.totalLikes }}</span>
                </div>

                <div class="flex gap-2 items-center">
                  <svg class="text-foreground" width="25" height="24" viewBox="0 0 25 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path d="M3.5 11.5C3.49656 12.8199 3.80493 14.1219 4.4 15.3C5.10557 16.7118 6.19025 17.8992 7.53255 18.7293C8.87485 19.5594 10.4218 19.9994 12 20C13.3199 20.0035 14.6219 19.6951 15.8 19.1L21.5 21L19.6 15.3C20.1951 14.1219 20.5034 12.8199 20.5 11.5C20.4994 9.92179 20.0594 8.37488 19.2293 7.03258C18.3992 5.69028 17.2117 4.6056 15.8 3.90003C14.6219 3.30496 13.3199 2.99659 12 3.00003H11.5C9.41565 3.11502 7.44696 3.99479 5.97086 5.47089C4.49476 6.94699 3.61499 8.91568 3.5 11V11.5Z" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                  </svg>


                  <span class="text-foreground  text-sm font-normal leading-tight">{{ post.comments.length }}</span>
                </div>

                <div class="flex gap-2 items-center">
                  <button @click="handleBookmark">
                    <svg class="text-foreground" width="16" height="20" viewBox="0 0 16 20" :fill="post.favorite ? 'currentColor' : 'none'"xmlns="http://www.w3.org/2000/svg">
                      <path d="M15 19L8 15L1 19V3C1 2.46957 1.21071 1.96086 1.58579 1.58579C1.96086 1.21071 2.46957 1 3 1H13C13.5304 1 14.0391 1.21071 14.4142 1.58579C14.7893 1.96086 15 2.46957 15 3V19Z" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                  </button>


                  <span class="text-foreground  text-sm font-normal leading-tight">{{ post.totalFavorites }}</span>
                </div>
              </div>

            <Textarea class="h-24 resize-none" placeholder="Type your comment here..." v-model="comment.text"/>
            <Button class="mx-auto"  v-on:click="onSaveComment">Post</Button>
          </div>
        </div>
        
    </div>
    
</template>

<script>

import {Avatar, AvatarFallback, AvatarImage} from "@/components/ui/avatar";
import {Separator} from "@/components/ui/separator";
import {Textarea} from "@/components/ui/textarea";
import postService from '../services/PostService';
import commentService from '../services/CommentService';
import { Button } from "@/components/ui/button";
import moment from "moment";
import CommentCard from "@/components/CommentCard.vue";
import {toast, Toaster} from 'vue-sonner'






export default {
    components: { Textarea, Separator, Avatar, AvatarFallback, AvatarImage, Button, Toaster, CommentCard },
  computed: {
    moment() {
      return moment
    },
  },
   methods: {
     getPost() {
       postService.getByRouteParam(this.$route.params.id).then(response => {
         if (response.status === 200) {
           this.post = response.data
           console.log(this.post.comments)
         }
       }).catch(error => {
         console.error('Error: ', error)
       })
     },

     onSaveComment(){
      commentService.save(this.$route.params.id, this.comment)
      .then(response => {
        if(response.status === 200){
         
        this.post.comments.unshift(response.data);
          toast('Comment added successfully.');
            // setTimeout(() => {
            //   window.location.reload();
            // }, 100)
          this.comment = {}
        }
      }).catch(error => {
        console.error('Error: ', error);
      })
     },
     handleBookmark() {
       if (!this.$store.state.token) {
         this.togglePrompt = true;
         return;
       }

       if (!this.post.favorite) {
         postService.bookmarkPostById(this.post.id).then(response => {
           if (response.status === 204) {
             this.$store.commit("SET_FAVORITE", this.post.id);
             this.post.favorite = true;
             this.post.totalFavorites += 1;
           }
         })
       } else {
         postService.removeBookmarkPostById(this.post.id).then(response => {
           if (response.status === 204) {
             this.$store.commit("SET_FAVORITE", this.post.id);
             this.post.favorite = false;
             this.post.totalFavorites -= 1;
           }
         })
       }
     },
     handleLike(){
     
      if (this.post.liked) {
        postService.unlikePostById(this.post.id).then(response => {
          if (response.status === 204) {
              this.$store.commit("SET_LIKED", this.post.id);
              this.post.liked = false;
              this.post.totalLikes -= 1; 
          }
        })
      } else {
        
        postService.likePostById(this.post.id).then(response => {
          if (response.status === 204) {
            this.$store.commit("SET_LIKED", this.post.id);
            this.post.liked = true;
            this.post.totalLikes += 1; 
          }
        })
      }

     }
   },
    data() {
        return {
            post: {},
            comment:{
              text:''
            },
        }
    },
    created() {
      this.getPost()
      console.log(this.post)
    },
}
</script>