<template>
  <div class="w-full min-h-screen flex items-center justify-center p-3 gap-3">
    <div class="self-stretch w-full lg:w-1/2 flex flex-col">
      <a href="/">
        <h1 class="pr-4 font-bold text-2xl mx-2">LOGO</h1>
      </a>
      <div class="w-full h-full flex flex-col items-center justify-center gap-5 px-20 md:px-40 lg:px-20 2xl:px-56">
        <div class="flex flex-col items-center gap-2">
          <h2 class="text-5xl font-extrabold leading-[48px]">Sign In</h2>
          <p class="w-[450px] text-center text-slate-900 text-xl font-normal leading-relaxed">Enter your info below to sign into your account.</p>
        </div>

        <form class="flex flex-col w-[450px] justify-start" @submit.prevent="login">
          <FormField name="username">
            <FormItem>
              <FormLabel>Username</FormLabel>
              <FormControl>
                <Input type="text" placeholder="johndoe" v-model="user.username" />
              </FormControl>
              <FormMessage />
            </FormItem>

            <FormItem class="mt-4">
              <FormLabel>Password</FormLabel>
              <FormControl>
                <Input type="password" placeholder="*************" v-model="user.password" />
              </FormControl>
              <FormMessage />
            </FormItem>
          </FormField>
          <Button type="submit" class="mt-6 mx-[10%] py-2">
            Sign In
          </Button>
        </form>

        <p class="mt-2">Don't have an account? <router-link class="underline" v-bind:to="{ name : 'register'}">Sign Up</router-link></p>
      </div>
    </div>
    <div class="w-1/2 hidden self-stretch lg:flex bg-foreground/20 rounded-lg"></div>
  </div>
</template>

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
      this.$store.commit("SET_LOADING", true);

      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$store.commit("TOGGLE_VALIDATION_STATUS");
            this.$store.commit("SET_LOADING", false);
            this.$router.push("/app");
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