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

        <Motion :animate="{ y: toggleImageAnimation ? 100 : -100 }" :initial="{ y: -100 }" :transition="{duration: 2.5} ">
            <div class="flex flex-col w-full min-w-[308px] h-full gap-5 mt-20 ">
              <div v-for="(pic, index) in pictures.slice(0, 4)" :key="index" class="">
                <PictureCard :pic="pic" />
              </div>
            </div>
          </Motion>

        <Motion  :animate="{ y: toggleImageAnimation ? 100 : -100 }" :initial="{ y: -100 }" :transition="{duration: 2.5}">
          <div class="flex flex-col w-full min-w-[308px] gap-5 will-change-transform">
            <div v-for="(pic, index) in pictures.slice(5, 9)" :key="index" class="">
              <PictureCard :pic="pic"  />
            </div>
          </div>
        </Motion>


        <Motion :animate="{ y: toggleImageAnimation ? 100 : 300 }" :initial="{ y: 300 }" :transition="{duration: 2.5}">
          <div class="flex flex-col w-full h-full min-w-[308px] gap-5 mt-20 will-change-transform">
            <div v-for="(pic, index) in pictures.slice(10, 14)" :key="index" class="">
              <PictureCard :pic="pic" />
            </div>
          </div>
        </Motion>


        <Motion :animate="{ y: toggleImageAnimation ? 100 : -100 }" :initial="{ y: -100 }" :transition="{duration: 2.5}">
          <div class="flex flex-col w-full min-w-[308px] gap-5 will-change-transform">
            <div v-for="(pic, index) in pictures.slice(12, 16)" :key="index" class="">
              <PictureCard :pic="pic"   />
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
        mounted() {
          this.toggleImageAnimation = true;
        },
        data(){
            return {
                toggleImageAnimation: false,
                pictures: [
                  "https://plus.unsplash.com/premium_photo-1665311513813-8576a87a251f?q=80&w=2875&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                    "https://images.unsplash.com/photo-1563217702-e4754ce9ae1a?q=80&w=2787&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                    "https://images.unsplash.com/photo-1550236520-7050f3582da0?q=80&w=2835&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                    "https://images.unsplash.com/photo-1706029141046-2e1af434f735?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8cGVvcGxlJTIwcGljdHVyZXMlMjAxJTNBMXxlbnwwfHwwfHx8MA%3D%3D",
                    "https://images.unsplash.com/photo-1491438590914-bc09fcaaf77a?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8cGVvcGxlJTIwcGljdHVyZXMlMjAxJTNBMXxlbnwwfHwwfHx8MA%3D%3D",
                    "https://images.unsplash.com/photo-1479936343636-73cdc5aae0c3?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTF8fHBlb3BsZSUyMHBpY3R1cmVzJTIwMSUzQTF8ZW58MHx8MHx8fDA%3D",
                    "https://images.unsplash.com/photo-1526413232644-8a40f03cc03b?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTJ8fHBlb3BsZSUyMHBpY3R1cmVzJTIwMSUzQTF8ZW58MHx8MHx8fDA%3D",
                    "https://images.unsplash.com/photo-1484712401471-05c7215830eb?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjB8fHBlb3BsZSUyMHBpY3R1cmVzJTIwMSUzQTF8ZW58MHx8MHx8fDA%3D",
                    "https://images.unsplash.com/photo-1440133197387-5a6020d5ace2?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NTN8fHBlb3BsZSUyMHBpY3R1cmVzJTIwMSUzQTF8ZW58MHx8MHx8fDA%3D",
                    "https://images.unsplash.com/photo-1469571486292-0ba58a3f068b?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NTV8fHBlb3BsZSUyMHBpY3R1cmVzJTIwMSUzQTF8ZW58MHx8MHx8fDA%3D",
                    "https://images.unsplash.com/photo-1474314881477-04c4aac40a0e?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NTh8fHBlb3BsZSUyMHBpY3R1cmVzJTIwMSUzQTF8ZW58MHx8MHx8fDA%3D",
                    "https://images.unsplash.com/photo-1445633629932-0029acc44e88?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NzJ8fHBlb3BsZSUyMHBpY3R1cmVzJTIwMSUzQTF8ZW58MHx8MHx8fDA%3D",
                    "https://images.unsplash.com/photo-1517840933437-c41356892b35?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OTF8fHBlb3BsZSUyMHBpY3R1cmVzJTIwMSUzQTF8ZW58MHx8MHx8fDA%3D",
                    "https://images.unsplash.com/photo-1473531761844-5a14668fc8f8?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTEwfHxwZW9wbGUlMjBwaWN0dXJlcyUyMDElM0ExfGVufDB8fDB8fHww",
                    "https://images.unsplash.com/photo-1527631746610-bca00a040d60?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTIxfHxwZW9wbGUlMjBwaWN0dXJlcyUyMDElM0ExfGVufDB8fDB8fHww",
                    "https://images.unsplash.com/photo-1530893608544-cd10fda1ac14?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTI1fHxwZW9wbGUlMjBwaWN0dXJlcyUyMDElM0ExfGVufDB8fDB8fHww",
                    "https://images.unsplash.com/photo-1496240476075-8bbe454c971a?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTM3fHxwZW9wbGUlMjBwaWN0dXJlcyUyMDElM0ExfGVufDB8fDB8fHww",
                    "https://images.unsplash.com/photo-1439778615639-28529f7628bc?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTUwfHxwZW9wbGUlMjBwaWN0dXJlcyUyMDElM0ExfGVufDB8fDB8fHww",
                    "https://images.unsplash.com/photo-1496345875659-11f7dd282d1d?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTYwfHxwZW9wbGUlMjBwaWN0dXJlcyUyMDElM0ExfGVufDB8fDB8fHww",
                    "https://images.unsplash.com/photo-1527058054345-f870ffe763eb?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTg2fHxwZW9wbGUlMjBwaWN0dXJlcyUyMDElM0ExfGVufDB8fDB8fHww",
                    "https://images.unsplash.com/photo-1531727991582-cfd25ce79613?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTk0fHxwZW9wbGUlMjBwaWN0dXJlcyUyMDElM0ExfGVufDB8fDB8fHww"
                ]
            }
        },
        components: {
            Button,
            PictureCard,
            Motion
        }
    }
</script>
