<template>
    <div class="flex w-full container px-4 pt-5 flex-wrap md:flex-nowrap">
        <div class="flex-[2] aspect-square min-w-[28rem] max-w-[48.5rem]">
            <img class="w-full aspect-square rounded-lg" :alt="post.image.altDesc" :src="`http://localhost:9000/posts/${post.id}/image`">
        </div>

        <div class="flex-[1] xl:px-8 pt-8 md:pt-0">
            <div class="flex flex-col">
              <div class="flex w-full pb-4">
                <div class="flex gap-2">
                  <Avatar @click="loger" class="h-14 w-14">
                    <AvatarImage src="https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg" alt="@radix-vue" />
                    <AvatarFallback>CN</AvatarFallback>
                  </Avatar>

                  <div class="flex flex-col gap-0 justify-center">
                    <h5 class="font-semibold text-lg leading-[1rem]">shadcn</h5>
                    <p class="">{{ moment(post.createdOn).utc().local().fromNow()  }}</p>
                  </div>
                </div>
              </div>

              <Separator class="bg-foreground/20"/>
            </div>

          <div class="flex-1 w-full h-[35rem]  py-4 px-4 overflow-y-scroll gap-4 flex flex-col">
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
          </div>


          <div class="h-52 mb-2 w-full flex flex-col gap-3 pt-2">
              <div class="flex w-full justify-between">
                <div class="flex gap-2 items-center">
                  <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <rect width="24" height="24" fill="none"/>
                    <path d="M20.4201 4.58002C19.9184 4.07659 19.3223 3.67716 18.6659 3.40461C18.0095 3.13206 17.3058 2.99176 16.5951 2.99176C15.8844 2.99176 15.1806 3.13206 14.5243 3.40461C13.8679 3.67716 13.2718 4.07659 12.7701 4.58002L12.0001 5.36002L11.2301 4.58002C10.7284 4.07659 10.1323 3.67716 9.47591 3.40461C8.81953 3.13206 8.1158 2.99176 7.40509 2.99176C6.69437 2.99176 5.99065 3.13206 5.33427 3.40461C4.67789 3.67716 4.08176 4.07659 3.58009 4.58002C1.46009 6.70002 1.33009 10.28 4.00009 13L12.0001 21L20.0001 13C22.6701 10.28 22.5401 6.70002 20.4201 4.58002Z" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                  </svg>

                  <span class="text-black text-sm font-normal leading-tight">83</span>
                </div>

                <div class="flex gap-2 items-center">
                  <svg width="25" height="24" viewBox="0 0 25 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path d="M3.5 11.5C3.49656 12.8199 3.80493 14.1219 4.4 15.3C5.10557 16.7118 6.19025 17.8992 7.53255 18.7293C8.87485 19.5594 10.4218 19.9994 12 20C13.3199 20.0035 14.6219 19.6951 15.8 19.1L21.5 21L19.6 15.3C20.1951 14.1219 20.5034 12.8199 20.5 11.5C20.4994 9.92179 20.0594 8.37488 19.2293 7.03258C18.3992 5.69028 17.2117 4.6056 15.8 3.90003C14.6219 3.30496 13.3199 2.99659 12 3.00003H11.5C9.41565 3.11502 7.44696 3.99479 5.97086 5.47089C4.49476 6.94699 3.61499 8.91568 3.5 11V11.5Z" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                  </svg>


                  <span class="text-black text-sm font-normal leading-tight">83</span>
                </div>

                <div class="flex gap-2 items-center">
                  <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path d="M19 21L12 17L5 21V5C5 4.46957 5.21071 3.96086 5.58579 3.58579C5.96086 3.21071 6.46957 3 7 3H17C17.5304 3 18.0391 3.21071 18.4142 3.58579C18.7893 3.96086 19 4.46957 19 5V21Z" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                  </svg>


                  <span class="text-black text-sm font-normal leading-tight">83</span>
                </div>
              </div>

            <Textarea class="h-24 resize-none" placeholder="Type your comment here..." />
          </div>
        </div>
    </div>
</template>

<script>

import {Avatar, AvatarFallback, AvatarImage} from "@/components/ui/avatar";
import {Separator} from "@/components/ui/separator";
import {Textarea} from "@/components/ui/textarea";
import axios from "axios";
import moment from "moment";


export default {
    components: {Textarea, Separator, Avatar, AvatarFallback, AvatarImage},
  computed: {
    moment() {
      return moment
    }
  },
   methods: {
     getPost() {
       axios.get(`/posts/${this.$route.params.id}`).then(response => {
         if (response.status === 200) {
           this.post = response.data
           console.log(this.post)
         }
       }).catch(error => {
         console.error('Error: ', error)
       })
     }
   },
    data() {
        return {
            post: {}
        }
    },
    created() {
      this.getPost()
    },
}
</script>