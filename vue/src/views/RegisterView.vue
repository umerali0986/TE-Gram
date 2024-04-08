<!-- eslint-disable no-undef -->
<!-- eslint-disable no-undef -->
<template>
  <div class="grid grid-cols-2 h-screen w-full ">

    <div class=" container px-[30%] bg-white flex flex-col  justify-center items-center">
      
      <div class="text-center mb-8">
        <h1 class="text-6xl font-bold mb-3">Sign Up</h1>
        <p class="text-xl">Enter your info below to create your account</p>
      </div>

      <form class=" flex flex-col w-full justify-start" @submit="onSubmit">
        <FormField v-slot="{ componentField }" name="username">
          <FormItem>
            <FormLabel>Username</FormLabel>
            <FormControl>
              <Input type="text" placeholder="johndoe" v-bind="componentField" />
            </FormControl>          
            <FormMessage />
          </FormItem>

          <FormItem class="mt-4">
            <FormLabel>Email</FormLabel>
            <FormControl>
              <Input type="text" placeholder="name@example.com" v-bind="componentField" />
            </FormControl>
          
            <FormMessage />
          </FormItem>

          <FormItem class="mt-4">
            <FormLabel>Password</FormLabel>
            <FormControl>
              <Input type="text" placeholder="*************" v-bind="componentField" />
            </FormControl>
            <FormMessage />
          </FormItem>

          <FormItem class="mt-4">
            <FormLabel>Confirm Password</FormLabel>
            <FormControl>
              <Input type="text" placeholder="*************" v-bind="componentField" />
            </FormControl>
            <FormMessage />
          </FormItem>
        </FormField>
        <Button type="submit" class="mt-6 mx-[10%] py-2">
          Sign Up
        </Button>
      </form>

      <p class="mt-2">Already have an account? <router-link class="underline" v-bind:to="{ name : 'login'}">Sign In</router-link></p>
    </div>

    <div class="flex justify-center bg-black">
      <img src="../assets/background image.avif" class="h-full">
    </div>

  </div>
</template>


<script setup lang="ts">
import { useForm } from 'vee-validate'
import { toTypedSchema } from '@vee-validate/zod'
import * as z from 'zod'

import { Button } from '@/components/ui/button'
import {
  FormControl,
  FormDescription,
  FormField,
  FormItem,
  FormLabel,
  FormMessage,
} from '@/components/ui/form'
import { Input } from '@/components/ui/input'


const formSchema = toTypedSchema(z.object({
  username: z.string().min(2).max(50),
}))

const form = useForm({
  validationSchema: formSchema,
})

const onSubmit = form.handleSubmit((values) => {
  console.log('Form submitted!', values)
})



// export default {
//   data() {
//     return {
//       user: {
//         username: '',
//         email: '',
//         password: '',
//         confirmPassword: '',
//         role: 'user',
//       },
//       registrationErrors: false,
//       registrationErrorMsg: 'There were problems registering this user.',
//     };
//   },
//   methods: {
//     register() {
//       if (this.user.password != this.user.confirmPassword) {
//         this.registrationErrors = true;
//         this.registrationErrorMsg = 'Password & Confirm Password do not match.';
//       } else {
//         authService
//           .register(this.user)
//           .then((response) => {
//             if (response.status == 201) {
//               this.$router.push({
//                 path: '/login',
//                 query: { registration: 'success' },
//               });
//             }
//           })
//           .catch((error) => {
//             const response = error.response;
//             this.registrationErrors = true;
//             if (response.status === 400) {
//               this.registrationErrorMsg = 'Bad Request: Validation Errors';
//             }
//           });
//       }
//     },
//     clearErrors() {
//       this.registrationErrors = false;
//       this.registrationErrorMsg = 'There were problems registering this user.';
//     },
//   },
// });

</script>

