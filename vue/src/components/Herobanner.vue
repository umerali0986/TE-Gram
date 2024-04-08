<template>
    <div class="container overflow-hidden w-full max-h-screen py-96 flex items-center flex-col justify-center relative text-center">
        <h1 class="text-6xl font-bold w-[60%]">
            Medium length hero heading goes here
        </h1>
        <p class="w-[60%]">
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse varius enim in eros elementum tristique. Duis cursus, mi quis viverra ornare, eros dolor interdum nulla, ut commodo diam libero vitae erat.

        </p>
        <div>
            <Button>Get Started</Button>
            <Button>Learn More</Button>
        </div>

        <div class="w-full h-full absolute top-0 left-0">
            <div class="w-full h-full flex gap-1" >
                <div class="w-full">
                    <div v-for="(pic, index) in pictures" :key="index" class="mb-1">
                        <PictureCard v-if="index <= 4" />
                    </div>
                </div>
                <div class="w-full">
                    <div v-for="(pic, index) in pictures" :key="index" class="mb-1">
                        <PictureCard v-if="index > 4 && index <= 9" />
                    </div>
                </div>
                <div class="w-full">
                    <div v-for="(pic, index) in pictures" :key="index" class="mb-1">
                        <PictureCard v-if="index > 9 && index <= 14" />
                    </div>
                </div>
                <div class="w-full">
                    <div v-for="(pic, index) in pictures" :key="index" class="mb-1">
                        <PictureCard v-if="index > 14 && index <= 19" />
                    </div>
                </div>            
            </div>
        </div>
        

    </div>
</template>

<script>
    import {Button} from "@/components/ui/button";
    import PictureCard from "./PictureCard.vue";

    export default{

        data(){
            return {
                pictures: [ "path", "path", "etc...", 1, 2, 3, 4, 5, 6, 12, 23, 34, 1, 2, 3, 1, 2, 3, 4, 1]
            }
        },
        components: {
            Button,
            PictureCard
        }
    }
</script>