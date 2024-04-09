<template>
  <header
      class="top-0 h-14 flex items-center px-6"
      :class="{'container px-0 bg-transparent' : $route.path === '/', 'sticky left-0 bg-background' : $route.path === '/app'}"

  >
      <a href="/">
        <h1 class="pr-4 font-bold text-2xl">Logo</h1>
      </a>

    <div v-if="$route.path === '/'" class="flex-1 hidden md:flex">
      <Navbar />
    </div>

<<<<<<< HEAD
    <div class="md:flex hidden gap-2 items-center">
=======
    <div
        class="md:flex hidden gap-2 items-center"
        :class="{'flex-1 justify-end' : $route.path === '/app'}"
    >
>>>>>>> 84ee13d4b6f7776f4d4df4fdd751b2e5f9b80aa0
      <a v-if="!$store.state.isValidated" href="/login">
        <Button variant="ghost">
          Login
        </Button>
      </a>

<<<<<<< HEAD
      <router-link @click="logout" :to="{name: 'login'}">Logout</router-link>

      <a href="/app">
=======
      <router-link v-else @click="logout" :to="{name: 'login'}">Logout</router-link>

      <a href="/app" v-if="$route.path === '/'">
>>>>>>> 84ee13d4b6f7776f4d4df4fdd751b2e5f9b80aa0
        <Button>
          Try App
        </Button>
      </a>

      <DropdownMenu>
        <DropdownMenuTrigger as-child>
          <Button variant="outline">
            <MoonIcon class="h-[1.2rem] w-[1.2rem] rotate-0 scale-100 transition-all dark:-rotate-90 dark:scale-0" />
            <SunIcon class="absolute h-[1.2rem] w-[1.2rem] rotate-90 scale-0 transition-all dark:rotate-0 dark:scale-100" />
            <span class="sr-only">Toggle theme</span>
          </Button>
        </DropdownMenuTrigger>
        <DropdownMenuContent align="end">
          <DropdownMenuItem @click="mode = 'light'">
            Light
          </DropdownMenuItem>
          <DropdownMenuItem @click="mode = 'dark'">
            Dark
          </DropdownMenuItem>
          <DropdownMenuItem @click="mode = 'auto'">
            System
          </DropdownMenuItem>
        </DropdownMenuContent>
      </DropdownMenu>
    </div>

    <div class="flex-1 flex md:hidden items-center justify-end">
      <Sheet>
        <SheetTrigger>
          <HamburgerMenuIcon class="h-5 w-5"/>
        </SheetTrigger>
        <SheetContent class="w-screen min-h-screen flex flex-col items-center justify-center">
          <Button variant="link" class="text-3xl">
            Home
          </Button>

          <Button variant="link" class="text-3xl">
            Features
          </Button>

          <Button variant="link" class="text-3xl">
            Team
          </Button>

          <a v-if="!$store.state.isValidated" href="/login">
            <Button variant="link" class="text-3xl">
              Login
            </Button>
          </a>

          <a href="/app">
            <Button variant="link" class="text-3xl">
              Try App
            </Button>
          </a>
        </SheetContent>
      </Sheet>
    </div>
  </header>
</template>

<script>
import {useColorMode} from "@vueuse/core";

import { HamburgerMenuIcon, SunIcon, MoonIcon } from '@radix-icons/vue'

import {
  Sheet,
  SheetContent,
  SheetTrigger,
} from '@/components/ui/sheet'

import {
  DropdownMenu,
  DropdownMenuContent,
  DropdownMenuItem,
  DropdownMenuTrigger,
} from '@/components/ui/dropdown-menu'

import {defineComponent} from "vue";
import {Button} from "@/components/ui/button";
import Navbar from "@/components/Navbar.vue";

export default defineComponent({
  data() {
    return {
      mode: useColorMode()
    }
  },
  computed: {
    currentRouteName() {
      return this.$route.path;
    }
  },
  methods: {
    logout(){
      this.$store.commit("TOGGLE_VALIDATION_STATUS");
    }
  },
  components: {
    Button,
    Sheet,
    SheetContent,
    SheetTrigger,
    HamburgerMenuIcon,
    DropdownMenu,
    DropdownMenuContent,
    DropdownMenuItem,
    DropdownMenuTrigger,
    SunIcon,
    MoonIcon,
    Navbar
  }
})

</script>