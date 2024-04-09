<template>
  <header class="top-0 h-14 flex items-center">
    <h1 class="pr-4 font-bold text-2xl">Logo</h1>

    <div class="flex-1 hidden md:flex">
      <Navbar v-if="$route.path === '/'"/>
    </div>

    <div class="md:flex hidden gap-2 items-center">
      <a href="/login">
        <Button variant="ghost">
          Login
        </Button>
      </a>

      <a href="/app">
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

          <a href="/login">
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