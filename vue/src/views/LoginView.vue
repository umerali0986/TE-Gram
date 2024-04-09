<template>
  <div class="w-full min-h-screen flex items-center justify-center p-3 gap-3">
    <div class="self-stretch flex-1 flex flex-col">
      <a href="/">
        <h1 class="pr-4 font-bold text-2xl mx-2">LOGO</h1>
      </a>
      <div class="w-full h-full flex flex-col items-center justify-center gap-2 px-56">
        <h2 class="text-5xl font-extrabold leading-[48px]">Sign In</h2>
        <p class="w-[450px] text-center text-slate-900 text-xl font-normal font-['Geist'] leading-relaxed">Enter your info below to sign into your account.</p>

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
              <FormLabel>Password</FormLabel>
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

        <p class="mt-2">Don't have an account? <router-link class="underline" v-bind:to="{ name : 'login'}">Sign Up</router-link></p>
      </div>
    </div>
    <div class="flex-1 self-stretch flex bg-foreground/20  rounded-lg"></div>
  </div>
</template>

<!--<form v-on:submit.prevent="login">-->
<!--<h1 >Please Sign In</h1>-->
<!--<Button>Button</Button>-->
<!--<div role="alert" v-if="invalidCredentials">-->
<!--  Invalid username and password!-->
<!--</div>-->
<!--<div role="alert" v-if="this.$route.query.registration">-->
<!--  Thank you for registering, please sign in.-->
<!--</div>-->
<!--<div class="form-input-group">-->
<!--  <label for="username">Username</label>-->
<!--  <input type="text" id="username" v-model="user.username" required autofocus />-->
<!--</div>-->
<!--<div class="form-input-group">-->
<!--  <label for="password">Password</label>-->
<!--  <input type="password" id="password" v-model="user.password" required />-->
<!--</div>-->
<!--<button type="submit">Sign in</button>-->
<!--<p>-->
<!--  <router-link v-bind:to="{ name: 'register' }">Need an account? Sign up.</router-link></p>-->
<!--</form>-->

<script>
import authService from "../services/AuthService";
import { Button } from '@/components/ui/button';
import {FormControl, FormField, FormItem, FormLabel, FormMessage} from "@/components/ui/form";
import {Input} from "@/components/ui/input";

export default {
  components: {
    FormControl, FormMessage, FormField, Input, FormLabel, FormItem,
    Button
  },
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}
</style>