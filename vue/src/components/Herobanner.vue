<template>
    <div class="flex py-40 lg:py-20 xl:py-56 mt-4 relative items-center justify-center overflow-hidden">
      <div class="flex flex-col text-center justify-between items-center px-10 lg:px-80 gap-6 z-20">
        <h1 class="text-5xl font-bold">
          Elevate your Tech Elevator experience with Chat-TE. 
        </h1>
        <p class="text-lg">
          Chat-TE doesn't claim to revolutionize the social media 
          landscape. We do, however, offer a viable alternative 
          to Tech Elevator students who seek something more 
          personalized. Communicate with your fellow students, 
          past students, and those simply interested in the 
          culture of Tech Elevator. 
        </p>
        <div class="flex gap-4">
          <a href="/register">
            <Button>Get Started</Button>
          </a>
          <a href="#about">
            <Button variant="ghost">Learn More</Button>
          </a>
        </div>
      </div>

      <div class="absolute w-full h-full z-10 bg-gradient-to-b from-background/70 via-background/90 to-background/80"/>

      <div class="absolute w-fit lg:w-full h-[920px] bottom-96 lg:bottom-0 flex gap-5 justify-center items-start">

        <Motion :animate="{ y: 100 }" :initial="{ y: 200 }" :transition="{duration: 1}">
            <div class="flex flex-col w-full min-w-[308px] h-full gap-5 mt-20">
              <div v-for="(pic, index) in pictures" :key="index" class="">
                <PictureCard v-if="index <= 4" />
              </div>
            </div>
          </Motion>

        <Motion :animate="{ y: 100 }" :initial="{ y: -100 }" :transition="{duration: 1}">
          <div class="flex flex-col w-full min-w-[308px] gap-5">
            <div v-for="(pic, index) in pictures" :key="index" class="">
              <PictureCard v-if="index <= 4" />
            </div>
          </div>
        </Motion>


        <Motion :animate="{ y: 100 }" :initial="{ y: 300 }" :transition="{duration: 1}">
          <div class="flex flex-col w-full h-full min-w-[308px] gap-5 mt-20">
            <div v-for="(pic, index) in pictures" :key="index" class="">
              <PictureCard v-if="index <= 4" />
            </div>
          </div>
        </Motion>


        <Motion :animate="{ y: 100 }" :initial="{ y: -100 }" :transition="{duration: 1}">
          <div class="flex flex-col w-full min-w-[308px] gap-5">
            <div v-for="(pic, index) in pictures" :key="index" class="">
              <PictureCard v-if="index <= 4" />
            </div>
          </div>
        </Motion>

        </div>
    </div>
</template>

<script>
    import {Button} from "@/components/ui/button";
    import PictureCard from "./PictureCard.vue";
    import { Motion } from "@oku-ui/motion";

    export default{

        data(){
            return {
                pictures: [ "path", "path", "etc...", 1, 2, 3, 4, 5, 6, 12, 23, 34, 1, 2, 3, 1, 2, 3, 4, 1]
            }
        },
        components: {
            Button,
            PictureCard,
            Motion
        }
    }
</script>
