<!-- eslint-disable no-undef -->
<!-- eslint-disable no-undef -->
<template>
  <div class="w-full min-h-screen flex items-center justify-center p-3 gap-3">

<!--    TODO: Add Error Message -->
    <div class="self-stretch w-full lg:w-1/2 flex flex-col">
      <a href="/">
        <h1 class="pr-4 font-bold text-2xl mx-2">LOGO</h1>
      </a>
     <div class="w-full h-full flex flex-col items-center justify-center gap-5 px-20 md:px-40 lg:px-20 2xl:px-56">
       <div class="flex flex-col items-center gap-2">
         <h1 class="text-5xl font-extrabold leading-[48px]">Sign Up</h1>
         <p class="w-[450px] text-center text-slate-900 text-xl font-normal leading-relaxed">Enter your info below to create your account</p>
       </div>

       <form class="flex flex-col w-[450px] justify-start" @submit.prevent="register">
         <FormField name="username">
           <FormItem>
             <FormLabel>Username</FormLabel>
             <FormControl>
               <Input type="text" placeholder="johndoe" v-model="user.username" />
             </FormControl>
           </FormItem>

           <FormItem class="mt-4">
             <FormLabel>Email</FormLabel>
             <FormControl>
               <Input type="email" placeholder="name@example.com" v-model="user.email" />
             </FormControl>
           </FormItem>

           <FormItem class="mt-4">
             <FormLabel>Password</FormLabel>
             <FormControl>
               <Input type="password" placeholder="*************" v-model="user.password"  />
             </FormControl>
           </FormItem>

           <FormItem class="mt-4">
             <FormLabel>Confirm Password</FormLabel>
             <FormControl>
               <Input type="password" placeholder="*************" v-model="user.confirmPassword"  />
             </FormControl>
           </FormItem>
           <p class="text-red-500" v-if="registrationErrors">{{ registrationErrorMsg }}</p>
         </FormField>
         <Button type="submit" class="mt-6 mx-[10%] py-2">
           Sign Up
         </Button>
       </form>

       <p class="mt-2">Already have an account? <router-link class="underline" v-bind:to="{ name : 'login'}">Sign In</router-link></p>
     </div>
     </div>

    <div class="w-1/2 hidden self-stretch lg:flex bg-black justify-center rounded-lg overflow-hidden">
      <img src="../assets/background image.avif" class="h-full">
    </div>

  </div>
</template>


<script>
import authService from '@/services/AuthService';
import { Button } from '@/components/ui/button'
import {
  FormControl,
  FormField,
  FormItem,
  FormLabel,
} from '@/components/ui/form'
import { Input } from '@/components/ui/input'

export default {
  data() {
    return {
      user: {
        username: '',
        email: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  components: {
    FormControl,
    FormField,
    FormItem,
    FormLabel,
    Button,
    Input
  },
  methods: {
    register() {
      this.$store.commit("SET_LOADING", true);
      if (this.user.username === ''){
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Please enter username.';
      }
      else if (this.user.email === ''){
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Please enter email.';
      }
      else if (this.user.password === ''){
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Please enter password.';
      }
      else if (this.user.confirmPassword === ''){
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Please confirm password.';
      }
      else if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status === 201) {
              this.$store.commit("TOGGLE_VALIDATION_STATUS");
              this.$store.commit("SET_LOADING", false);
              this.$router.push({
                path: '/app',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};

</script>

