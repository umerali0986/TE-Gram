const style = "flex"

<template>
  <header class="container sticky top-0 h-14 border-2 border-red-500 flex items-center">
    <h1 class="pr-4 font-bold text-2xl">Logo</h1>

    <div class="flex-1 hidden md:flex">
      <NavigationMenu>
        <NavigationMenuList>
          <NavigationMenuItem>
            <NavigationMenuLink href="/" :class="navigationMenuTriggerStyle()">
              Home
            </NavigationMenuLink>
          </NavigationMenuItem>

          <NavigationMenuItem>
            <NavigationMenuLink href="/" :class="navigationMenuTriggerStyle()">
              Features
            </NavigationMenuLink>
          </NavigationMenuItem>

          <NavigationMenuItem>
            <NavigationMenuLink href="/" :class="navigationMenuTriggerStyle()">
              Team
            </NavigationMenuLink>
          </NavigationMenuItem>
        </NavigationMenuList>
      </NavigationMenu>
    </div>

    <div class="md:flex hidden gap-2 items-center">
      <Button variant="ghost">
        Login
      </Button>

      <Button>
        Try App
      </Button>

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

          <Button variant="link" class="text-3xl">
            Login
          </Button>

          <Button variant="link" class="text-3xl">
            Try App
          </Button>
        </SheetContent>
      </Sheet>
    </div>
  </header>
</template>

<script>
import {useColorMode} from "@vueuse/core";

import {
  NavigationMenu,
  NavigationMenuContent,
  NavigationMenuItem,
  NavigationMenuLink,
  NavigationMenuList,
  NavigationMenuTrigger, navigationMenuTriggerStyle,
} from '@/components/ui/navigation-menu'

import { HamburgerMenuIcon, SunIcon, MoonIcon } from '@radix-icons/vue'

import {
  Sheet,
  SheetContent,
  SheetDescription,
  SheetHeader,
  SheetTitle,
  SheetTrigger,
} from '@/components/ui/sheet'

import {
  DropdownMenu,
  DropdownMenuContent,
  DropdownMenuItem,
  DropdownMenuLabel,
  DropdownMenuSeparator,
  DropdownMenuTrigger,
} from '@/components/ui/dropdown-menu'

import {defineComponent} from "vue";
import {Button} from "@/components/ui/button";

export default defineComponent({
  methods: {navigationMenuTriggerStyle},
  data() {
    return {
      mode: useColorMode()
    }
  },
  components: {
    Button,
    NavigationMenu,
    NavigationMenuItem,
    HamburgerMenuIcon,
    NavigationMenuLink,
    NavigationMenuList,
    Sheet,
    SheetContent,
    SheetTrigger,
    DropdownMenu,
    DropdownMenuContent,
    DropdownMenuItem,
    DropdownMenuTrigger,
    SunIcon,
    MoonIcon
  }
})

</script>