<template>
  <header
      class="top-0 h-14 flex items-center px-6 border-b z-10"
      :class="{'container px-0' : $route.path === '/', ' bg-background' : $route.path === '/app'}"

  >
    <div v-if="$route.path.includes('/app') && $store.state.token" class="flex bg-background mr-3 md:hidden items-center justify-end">
      <Sheet>
        <SheetTrigger>
          <HamburgerMenuIcon class="h-5 w-5"/>
        </SheetTrigger>
        <SheetContent side="left" class="min-h-screen flex flex-col items-center justify-center">
          <Sidebar :show="false"/>
        </SheetContent>
      </Sheet>
    </div>

      <a href="/">
        <h1 class="pr-4 font-bold inline-block text-2xl text-foreground/90">Chat<b class="text-purple-500">TE</b></h1>
      </a>

    <div class="flex-1 hidden md:flex">
      <Navbar v-if="$route.path === '/'"/>
    </div>

    <div
        class="md:flex hidden gap-2 items-center"
        :class="{'flex-1 justify-end' : $route.path === '/app'}"
    >
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

      <router-link :to="{name: 'register'}" v-if="$route.path === '/app' && !$store.state.token" >
        <Button  variant="outline" >
          Register
        </Button>
      </router-link>

      <router-link :to="{name: 'login'}" >
        <Button v-if="!$store.state.token" :variant="$route.path === '/' ? 'ghost' : ''">
          Login
        </Button>
      </router-link>

      <a href="/app" v-if="$route.path === '/'">
        <Button>
          Try App
        </Button>
      </a>


    </div>

    <div v-if="$route.path === '/'" class="flex-1 flex md:hidden items-center justify-end">
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

          <a v-if="!$store.state.token" href="/login">
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
import Sidebar from "@/components/Sidebar.vue";

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
    Sidebar,
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