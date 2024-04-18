<template>
  <div class="container min-h-screen flex flex-col">
    <Herobanner />
    <div id="about" class="w-full h-fit flex my-28 gap-20 lg:gap-32 flex-wrap lg:flex-nowrap">
      <div class="lg:w-2/3 flex flex-col gap-4">
        <p class="text-base font-semibold leading-7 text-primary">Features</p>
        <h2 class="text-foreground text-5xl font-extrabold leading-[48px]">
          Check out Chat-TE's slew of special features!
        </h2>
        <p class="text-base font-normal leading-7">
          Chat-TE comes with a toolbox of special features to help Tech Elevator 
          students share their experiences with the world! Upload
          photos. Like, save, and comment the photos of your peers, 
          professors, and students of the past. 
        </p>
      </div>

      <div class="w-full flex h-full gap-10 flex-wrap lg:flex-nowrap">
        <div class="w-full h-full flex lg:flex-col flex-wrap gap-10">
          <div class="flex flex-col h-1/2 gap-4">
            <svg class="text-foreground" width="48" height="48" viewBox="0 0 48 48" fill="none" xmlns="http://www.w3.org/2000/svg">
              <path d="M40.8402 9.15998C39.8368 8.15313 38.6446 7.35425 37.3318 6.80915C36.0191 6.26405 34.6116 5.98346 33.1902 5.98346C31.7687 5.98346 30.3613 6.26405 29.0485 6.80915C27.7358 7.35425 26.5435 8.15313 25.5402 9.15998L24.0002 10.72L22.4602 9.15998C21.4568 8.15313 20.2646 7.35425 18.9518 6.80915C17.6391 6.26405 16.2316 5.98346 14.8102 5.98346C13.3887 5.98346 11.9813 6.26405 10.6685 6.80915C9.35577 7.35425 8.16353 8.15313 7.16017 9.15998C2.92017 13.4 2.66017 20.56 8.00017 26L24.0002 42L40.0002 26C45.3402 20.56 45.0802 13.4 40.8402 9.15998Z" fill="currentColor" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
            </svg>
            <h3 class="leading-9 font-semibold text-2xl">
              Like a photo!
            </h3>
            <p class="">
              Did someone's post bring a smile to your face? Let them know you appreciate it by giving them a like!
            </p>

          </div>

          <div class="flex flex-col h-1/2 gap-4">
            <svg class="text-foreground" width="48" height="48" viewBox="0 0 48 48" fill="none" xmlns="http://www.w3.org/2000/svg">
              <path d="M6 23.0001C5.99312 25.6398 6.60986 28.2438 7.8 30.6001C9.21113 33.4235 11.3805 35.7984 14.0651 37.4586C16.7497 39.1188 19.8435 39.9988 23 40.0001C25.6397 40.0069 28.2438 39.3902 30.6 38.2001L42 42.0001L38.2 30.6001C39.3901 28.2438 40.0069 25.6398 40 23.0001C39.9988 19.8436 39.1188 16.7498 37.4586 14.0652C35.7983 11.3806 33.4235 9.21119 30.6 7.80006C28.2438 6.60992 25.6397 5.99317 23 6.00006H22C17.8313 6.23004 13.8939 7.98958 10.9417 10.9418C7.98952 13.894 6.22998 17.8314 6 22.0001V23.0001Z" fill="currentColor" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
            </svg>
            <h3 class="leading-9 font-semibold text-2xl">
              Comment on a post! 
            </h3>
            <p class="">
              They say a picture says a thousand words, but a thousand isn't always enough! 
            </p>
          </div>


        </div>

        <div class="w-full h-full flex flex-col gap-10">
          <div class="flex h-1/2 flex-col gap-4">
            <svg class="text-foreground" width="48" height="48" viewBox="0 0 48 48" fill="none" xmlns="http://www.w3.org/2000/svg">
              <path d="M38 42L24 34L10 42V10C10 8.93913 10.4214 7.92172 11.1716 7.17157C11.9217 6.42143 12.9391 6 14 6H34C35.0609 6 36.0783 6.42143 36.8284 7.17157C37.5786 7.92172 38 8.93913 38 10V42Z" fill="currentColor" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
            </svg>

            <h3 class="leading-9 font-semibold text-2xl">
              Save a photo! 
            </h3>
            <p class="">
              Images are powerful things. They can fill us with emotion and spark inspiration. Why not save 
              a few? 
            </p>

          </div>

          <div class="flex  h-1/2 flex-col gap-4">
            <svg class="text-foreground" width="48" height="48" viewBox="0 0 48 48" fill="none" xmlns="http://www.w3.org/2000/svg">
              <path d="M38 6H10C7.79086 6 6 7.79086 6 10V38C6 40.2091 7.79086 42 10 42H38C40.2091 42 42 40.2091 42 38V10C42 7.79086 40.2091 6 38 6Z" fill="currentColor" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
              <path class="text-background" d="M24 16V32" stroke="currentColor" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
              <path class="text-background" d="M16 24H32" stroke="currentColor" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
            </svg>

            <h3 class="leading-9 font-semibold text-2xl">
              Upload your own photo! 
            </h3>
            <p class="">
              Every's life is a unique experience. Share your perspective with the world!
            </p>
          </div>


        </div>
      </div>
    </div>
    
    <div id="team" class="lg:my-28 flex flex-col gap-10">
      <div class="w-full flex flex-col gap-3">
        <p class="text-primary text-base font-semibold leading-7">About</p>
        <h2 class="text-foreground text-5xl font-extrabold leading-[48px]">
          Our Team
        </h2>
        <p class="text-base font-normal leading-7">
          Meet the Chat-TE development team!
        </p>
      </div>
      
      <div class="flex w-full h-fit gap-12 flex-col overflow-hidden">
       <Motion :animate="{ x: location }">
         <div class="flex w-full h-fit gap-12 flex-wrap md:flex-nowrap">
           <div class="w-full min-w-[372px] h-fit leading-7">
             <div class="w-full h-[395px] bg-foreground/20 rounded-md">
               <img class="min-h-full object-cover" src="https://i.imgur.com/uid7l7U.jpeg" alt="Picture of Dustin">

             </div>
             <h4 class="text-2xl font-semibold mt-3">Dustin Dobos</h4>
             <h5 class="font-medium text-lg">Bug Chaser</h5>
             <p class="mt-1">Creative, self-driven US Army veteran with a passion for bringing imagination to life.
             </p>
           </div>

           <div class="w-full min-w-[372px] h-fit leading-7">
             <div class="w-full h-[395px] bg-foreground/20 rounded-md overflow-hidden flex items-center pt-36 relative">
              <img src="https://i.imgur.com/VVCiWkt.jpeg" class="object-cover" alt="Picture of Enrique">
             </div>
             <h4 class="text-2xl font-semibold mt-3">Enrique Cedeno</h4>
             <h5 class="font-medium text-lg">Git Ninja</h5>
             <p class="mt-1">
               Results-driven junior developer with a background in language research, adept at problem-solving and app development.
             </p>
           </div>

           <div class="w-full min-w-[372px] h-fit leading-7">
             <div class="w-full h-[395px] bg-foreground/20 rounded-md overflow-hidden">
               <img src="https://i.imgur.com/ErSxxAa.jpeg" class="object-cover min-h-full" alt="Picture of Umer">

             </div>
             <h4 class="text-2xl font-semibold mt-3">Umer Abubeker</h4>
             <h5 class="font-medium text-lg">Server Sensei</h5>
             <p class="mt-1">
               Passionate full-stack junior developer with a strong foundation in solving complex problems through an innovative coding and analytical mindset.
             </p>
           </div>
         </div>
       </Motion>

        <div  class="self-end hidden gap-2 sm:flex xl:hidden">
            <Button v-on:click="location = 0" variant="ghost" class=" w-10 h-10 text-foreground items-center flex">
              <svg class="w-6 h-6 scale-[2.0]" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path d="M15 18L9 12L15 6" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
              </svg>
            </Button>

           <Button v-on:click="location = -372" variant="ghost" class=" w-10 h-10 text-foreground items-center flex">
             <svg class="w-6 h-6 scale-[2.0]" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
               <path d="M9 18L15 12L9 6" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
             </svg>
           </Button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

  import Herobanner from '@/components/Herobanner.vue';
  import Navbar from "@/components/SiteHeader.vue";
  import SiteFooter from "@/components/SiteFooter.vue";
  import {Button} from "@/components/ui/button";
  import { Motion } from "@oku-ui/motion";

  export default {
    components: {
      Button,
      SiteFooter,
      Herobanner,
      Motion
    },

    data() {
      return {
        location: 0
      }
    }
  };
</script>
