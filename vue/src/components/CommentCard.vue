<template>
    <div class="w-full">
        <div class="flex gap-2">
            <Avatar>
                <AvatarImage src="https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg"
                    alt="@radix-vue" />
                <AvatarFallback>CN</AvatarFallback>
            </Avatar>

            <div class="flex flex-col gap-0 justify-center">
                <div class="flex-">
                    <b class="font-semibold inline-flex leading-[1rem]">{{ commentInfo.author.username }}</b> <p class="">{{commentInfo.text }}</p>
                </div>
                <p class="text-sm font-medium opacity-50">{{ moment(commentInfo.createdOn).utc().local().fromNow()  }}</p>
            </div>
        </div>
        
    </div>
</template>

<script>
import moment from "moment";
export default {

    props: ['commentInfo'],

    computed: {
    moment() {
      return moment
    }
  },
   

}
</script>