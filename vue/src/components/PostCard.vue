<template>
  <div
      class="flex flex-col min-w-[576px] w-full"
  >
      <div class="h-[588px] bg-foreground/20 rounded-md overflow-hidden">
        <router-link :to="{path:`app/post/${img.id}`, params:{id:img.id}}">
        <img :src="img.path" alt="Nature Picture" class="h-full w-full" />
        </router-link>
      </div>
     <div class="flex my-4">
       <div class="flex gap-2">
         <Avatar>
           <AvatarImage src="https://github.com/radix-vue.png" alt="@radix-vue" />
           <AvatarFallback>CN</AvatarFallback>
         </Avatar>
         
         <div class="flex flex-col gap-0 items-center justify-center">
           <h5 class="font-semibold leading-[1rem]">{{ img.username }}</h5>
           <p class="text-xs">{{ img.updated }}</p>
         </div>
       </div>

       <div class="flex-1 flex items-center justify-end gap-4" >
          <div class="font-medium">892 likes</div>
           <svg width="22" height="20" viewBox="0 0 22 20" fill="none" xmlns="http://www.w3.org/2000/svg">
             <path d="M19.4201 2.58002C18.9184 2.07659 18.3223 1.67716 17.6659 1.40461C17.0095 1.13206 16.3058 0.99176 15.5951 0.99176C14.8844 0.99176 14.1806 1.13206 13.5243 1.40461C12.8679 1.67716 12.2718 2.07659 11.7701 2.58002L11.0001 3.36002L10.2301 2.58002C9.72841 2.07659 9.13229 1.67716 8.47591 1.40461C7.81953 1.13206 7.1158 0.99176 6.40509 0.99176C5.69437 0.99176 4.99065 1.13206 4.33427 1.40461C3.67789 1.67716 3.08176 2.07659 2.58009 2.58002C0.460086 4.70002 0.330086 8.28002 3.00009 11L11.0001 19L19.0001 11C21.6701 8.28002 21.5401 4.70002 19.4201 2.58002Z" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
           </svg>

           <svg width="20" height="20" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
             <path d="M1 9.50003C0.996559 10.8199 1.30493 12.1219 1.9 13.3C2.60557 14.7118 3.69025 15.8992 5.03255 16.7293C6.37485 17.5594 7.92176 17.9994 9.5 18C10.8199 18.0035 12.1219 17.6951 13.3 17.1L19 19L17.1 13.3C17.6951 12.1219 18.0034 10.8199 18 9.50003C17.9994 7.92179 17.5594 6.37488 16.7293 5.03258C15.8992 3.69028 14.7117 2.6056 13.3 1.90003C12.1219 1.30496 10.8199 0.996587 9.5 1.00003H9C6.91565 1.11502 4.94696 1.99479 3.47086 3.47089C1.99476 4.94699 1.11499 6.91568 1 9.00003V9.50003Z" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
           </svg>

         <svg width="16" height="20" viewBox="0 0 16 20" fill="none" xmlns="http://www.w3.org/2000/svg">
           <path d="M15 19L8 15L1 19V3C1 2.46957 1.21071 1.96086 1.58579 1.58579C1.96086 1.21071 2.46957 1 3 1H13C13.5304 1 14.0391 1.21071 14.4142 1.58579C14.7893 1.96086 15 2.46957 15 3V19Z" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
         </svg>

         <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
           <path d="M12 13C12.5523 13 13 12.5523 13 12C13 11.4477 12.5523 11 12 11C11.4477 11 11 11.4477 11 12C11 12.5523 11.4477 13 12 13Z" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
           <path d="M19 13C19.5523 13 20 12.5523 20 12C20 11.4477 19.5523 11 19 11C18.4477 11 18 11.4477 18 12C18 12.5523 18.4477 13 19 13Z" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
           <path d="M5 13C5.55228 13 6 12.5523 6 12C6 11.4477 5.55228 11 5 11C4.44772 11 4 11.4477 4 12C4 12.5523 4.44772 13 5 13Z" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
         </svg>

       </div>
     </div>
  </div>
</template>

<script>

import {defineComponent} from "vue";
import {Avatar} from "@/components/ui/avatar";
import {Button} from "@/components/ui/button";

export default defineComponent({
  components: {Button, Avatar},
  props: ['img']
})
</script>