<template>
  <div class="h-full bg-background px-4 pb-2 md:flex lg:w-80 xl:w-96" :class="{ 'hidden': show }"
    v-if="$store.state.token">
    <div class="h-full w-full pb-2 ">
      <Toaster />
      <nav class="flex flex-col w-full h-full md:pt-4 items-center justify-between">
        <div class="flex flex-col items-center gap-2">
          <router-link to='/app'>
            <button class="py-2 px-4 flex gap-3 w-[280px] rounded hover:bg-accent">
              <svg class="primary-color" width="24" height="24" viewBox="0 0 24 24" fill="none"
                xmlns="http://www.w3.org/2000/svg">
                <path
                  d="M3 9L12 2L21 9V20C21 20.5304 20.7893 21.0391 20.4142 21.4142C20.0391 21.7893 19.5304 22 19 22H5C4.46957 22 3.96086 21.7893 3.58579 21.4142C3.21071 21.0391 3 20.5304 3 20V9Z"
                  stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                <path d="M9 22V12H15V22" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                  stroke-linejoin="round" />
              </svg>
              Home
            </button>
          </router-link>
          <router-link :to="`/app/profile/${$store.state.user.username}`">
            <button class="py-2 px-4 flex gap-3 w-[280px] rounded hover:bg-accent">
              <svg class="text-primary" width="24" height="24" viewBox="0 0 24 24" fill="none"
                xmlns="http://www.w3.org/2000/svg">
                <path
                  d="M19 21V19C19 17.9391 18.5786 16.9217 17.8284 16.1716C17.0783 15.4214 16.0609 15 15 15H9C7.93913 15 6.92172 15.4214 6.17157 16.1716C5.42143 16.9217 5 17.9391 5 19V21"
                  stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                <path
                  d="M12 11C14.2091 11 16 9.20914 16 7C16 4.79086 14.2091 3 12 3C9.79086 3 8 4.79086 8 7C8 9.20914 9.79086 11 12 11Z"
                  stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
              </svg>

              Profile
            </button>
          </router-link>

          <router-link to="/app/favorites">
            <button class="py-2 px-4 flex gap-3 w-[280px] rounded hover:bg-accent">
              <svg class="text-primary" width="24" height="24" viewBox="0 0 24 24" fill="none"
                xmlns="http://www.w3.org/2000/svg">
                <path
                  d="M19 21L12 17L5 21V5C5 4.46957 5.21071 3.96086 5.58579 3.58579C5.96086 3.21071 6.46957 3 7 3H17C17.5304 3 18.0391 3.21071 18.4142 3.58579C18.7893 3.96086 19 4.46957 19 5V21Z"
                  stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
              </svg>

              Saved
            </button>
          </router-link>

          <router-link to="/app/likes">
            <button class="py-2 px-4 flex gap-3 w-[280px] rounded hover:bg-accent">
              <svg class="text-primary" width="24" height="24" viewBox="0 0 24 24" fill="none"
                xmlns="http://www.w3.org/2000/svg">
                <path
                  d="M20.42 4.57996C19.9183 4.07653 19.3222 3.67709 18.6658 3.40455C18.0094 3.132 17.3057 2.9917 16.595 2.9917C15.8842 2.9917 15.1805 3.132 14.5241 3.40455C13.8678 3.67709 13.2716 4.07653 12.77 4.57996L12 5.35996L11.23 4.57996C10.7283 4.07653 10.1322 3.67709 9.47578 3.40455C8.81941 3.132 8.11568 2.9917 7.40496 2.9917C6.69425 2.9917 5.99052 3.132 5.33414 3.40455C4.67776 3.67709 4.08164 4.07653 3.57996 4.57996C1.45996 6.69996 1.32996 10.28 3.99996 13L12 21L20 13C22.67 10.28 22.54 6.69996 20.42 4.57996Z"
                  stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
              </svg>

              Likes
            </button>
          </router-link>

          <Dialog>
            <DialogTrigger>
              <button class="py-2 px-4 flex gap-3 w-[280px] rounded hover:bg-accent">
                <svg class="text-primary" width="24" height="24" viewBox="0 0 24 24" fill="none"
                  xmlns="http://www.w3.org/2000/svg">
                  <path
                    d="M21 12V19C21 19.5304 20.7893 20.0391 20.4142 20.4142C20.0391 20.7893 19.5304 21 19 21H5C4.46957 21 3.96086 20.7893 3.58579 20.4142C3.21071 20.0391 3 19.5304 3 19V5C3 4.46957 3.21071 3.96086 3.58579 3.58579C3.96086 3.21071 4.46957 3 5 3H12"
                    stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                  <path d="M16 5H22" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                    stroke-linejoin="round" />
                  <path d="M19 2V8" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                    stroke-linejoin="round" />
                  <path
                    d="M9 11C10.1046 11 11 10.1046 11 9C11 7.89543 10.1046 7 9 7C7.89543 7 7 7.89543 7 9C7 10.1046 7.89543 11 9 11Z"
                    stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                  <path
                    d="M21 14.9999L17.914 11.9139C17.5389 11.539 17.0303 11.3284 16.5 11.3284C15.9697 11.3284 15.4611 11.539 15.086 11.9139L6 20.9999"
                    stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                </svg>


                Upload
              </button>
            </DialogTrigger>

            <DialogContent class="max-w-fit">
              <DialogHeader>
                <DialogTitle>Upload a Picture</DialogTitle>
                <DialogDescription>
                  Please select the image you wish to upload.
                </DialogDescription>
              </DialogHeader>

              <div v-if="!isShowModal" class="flex flex-col items-center justify-between gap-2">
                <svg class="text-primary my-20" width="50" height="50" viewBox="0 0 24 24" fill="none"
                  xmlns="http://www.w3.org/2000/svg">
                  <path
                    d="M21 12V19C21 19.5304 20.7893 20.0391 20.4142 20.4142C20.0391 20.7893 19.5304 21 19 21H5C4.46957 21 3.96086 20.7893 3.58579 20.4142C3.21071 20.0391 3 19.5304 3 19V5C3 4.46957 3.21071 3.96086 3.58579 3.58579C3.96086 3.21071 4.46957 3 5 3H12"
                    stroke="currentColor" stroke-width="1" stroke-linecap="round" stroke-linejoin="round" />
                  <path d="M16 5H22" stroke="currentColor" stroke-width="1" stroke-linecap="round"
                    stroke-linejoin="round" />
                  <path d="M19 2V8" stroke="currentColor" stroke-width="1" stroke-linecap="round"
                    stroke-linejoin="round" />
                  <path
                    d="M9 11C10.1046 11 11 10.1046 11 9C11 7.89543 10.1046 7 9 7C7.89543 7 7 7.89543 7 9C7 10.1046 7.89543 11 9 11Z"
                    stroke="currentColor" stroke-width="1" stroke-linecap="round" stroke-linejoin="round" />
                  <path
                    d="M21 14.9999L17.914 11.9139C17.5389 11.539 17.0303 11.3284 16.5 11.3284C15.9697 11.3284 15.4611 11.539 15.086 11.9139L6 20.9999"
                    stroke="currentColor" stroke-width="1" stroke-linecap="round" stroke-linejoin="round" />
                </svg>

                <Input ref="uploadInput" id="picture" type="file" accept="image/jpg, image/jpeg, image/png, image/gif"
                  @change="selectFile" />
              </div>

              <div v-if="isShowModal" class="flex w-fit gap-10">
                <div class="h-[30rem] flex w-[30rem] rounded-lg">
                  <Cropper ref="cropper" :src="pic" :stencil-props="{ aspectRatio: 1 }" class="cropper" />
                </div>

                <div class="w-[30rem] flex px-4 flex-col gap-4">
                  <div class="flex h-fit gap-2 items-center">
                    <Avatar>
                      <AvatarImage src="https://github.com/radix-vue.png" alt="@radix-vue" />
                      <AvatarFallback>CN</AvatarFallback>
                    </Avatar>

                    <div class="flex justify-center">
                      <h5 class="font-semibold leading-[1rem]">shadcn</h5>
                    </div>
                  </div>

                  <Textarea v-model="post.caption" class="h-40 resize-none" placeholder="Write caption..." />
                  <Accordion type="single" collapsible>
                    <AccordionItem value="item-1">
                      <AccordionTrigger class="font-semibold">Privacy</AccordionTrigger>
                      <AccordionContent class="flex flex-col gap-2">
                        <div class="w-full flex justify-between">
                          <Label for="make-private">Make picture private</Label>
                          <Switch id="make-private" />
                        </div>

                        <p class="text-sm">
                          The switch controls the visibility of your photos. When this feature is enabled, your photos are
                          hidden from public view and can only be accessed by you.
                        </p>
                      </AccordionContent>
                    </AccordionItem>

                    <AccordionItem value="item-2">
                      <AccordionTrigger class="font-semibold">Accessibility</AccordionTrigger>
                      <AccordionContent class="flex flex-col gap-2 px-1">
                        <p class="text-sm">
                          Alt text describes your photos for people with visual impairments. Alt text will be
                          automatically created for your photos or you can choose to write your own.
                        </p>

                        <Input v-model="post.altDescription" type="text" placeholder="Write alt text..." />
                      </AccordionContent>
                    </AccordionItem>
                  </Accordion>
                </div>
              </div>

              <DialogFooter>
                <a href="">
                  <Button variant="ghost">
                    Cancel
                  </Button>
                </a>

                <Button v-on:click="handleSubmit">
                  Submit
                </Button>

              </DialogFooter>
            </DialogContent>
          </Dialog>
        </div>

        <div class="pb-16 flex flex-col items-center gap-2">
          <Dialog>
            <DialogTrigger>
              <button @click="showUpdateModal" class="py-2 px-4 flex gap-3 w-[280px] rounded hover:bg-accent">
                <svg class="text-primary" width="24" height="24" viewBox="0 0 24 24" fill="none"
                  xmlns="http://www.w3.org/2000/svg">
                  <path
                    d="M12.22 2H11.78C11.2496 2 10.7409 2.21071 10.3658 2.58579C9.99072 2.96086 9.78 3.46957 9.78 4V4.18C9.77964 4.53073 9.68706 4.87519 9.51154 5.17884C9.33602 5.48248 9.08374 5.73464 8.78 5.91L8.35 6.16C8.04596 6.33554 7.70108 6.42795 7.35 6.42795C6.99893 6.42795 6.65404 6.33554 6.35 6.16L6.2 6.08C5.74107 5.81526 5.19584 5.74344 4.684 5.88031C4.17217 6.01717 3.73555 6.35154 3.47 6.81L3.25 7.19C2.98526 7.64893 2.91345 8.19416 3.05031 8.706C3.18717 9.21783 3.52154 9.65445 3.98 9.92L4.13 10.02C4.43228 10.1945 4.68362 10.4451 4.85905 10.7468C5.03448 11.0486 5.1279 11.391 5.13 11.74V12.25C5.1314 12.6024 5.03965 12.949 4.86405 13.2545C4.68844 13.5601 4.43521 13.8138 4.13 13.99L3.98 14.08C3.52154 14.3456 3.18717 14.7822 3.05031 15.294C2.91345 15.8058 2.98526 16.3511 3.25 16.81L3.47 17.19C3.73555 17.6485 4.17217 17.9828 4.684 18.1197C5.19584 18.2566 5.74107 18.1847 6.2 17.92L6.35 17.84C6.65404 17.6645 6.99893 17.5721 7.35 17.5721C7.70108 17.5721 8.04596 17.6645 8.35 17.84L8.78 18.09C9.08374 18.2654 9.33602 18.5175 9.51154 18.8212C9.68706 19.1248 9.77964 19.4693 9.78 19.82V20C9.78 20.5304 9.99072 21.0391 10.3658 21.4142C10.7409 21.7893 11.2496 22 11.78 22H12.22C12.7504 22 13.2591 21.7893 13.6342 21.4142C14.0093 21.0391 14.22 20.5304 14.22 20V19.82C14.2204 19.4693 14.3129 19.1248 14.4885 18.8212C14.664 18.5175 14.9163 18.2654 15.22 18.09L15.65 17.84C15.954 17.6645 16.2989 17.5721 16.65 17.5721C17.0011 17.5721 17.346 17.6645 17.65 17.84L17.8 17.92C18.2589 18.1847 18.8042 18.2566 19.316 18.1197C19.8278 17.9828 20.2645 17.6485 20.53 17.19L20.75 16.8C21.0147 16.3411 21.0866 15.7958 20.9497 15.284C20.8128 14.7722 20.4785 14.3356 20.02 14.07L19.87 13.99C19.5648 13.8138 19.3116 13.5601 19.136 13.2545C18.9604 12.949 18.8686 12.6024 18.87 12.25V11.75C18.8686 11.3976 18.9604 11.051 19.136 10.7455C19.3116 10.4399 19.5648 10.1862 19.87 10.01L20.02 9.92C20.4785 9.65445 20.8128 9.21783 20.9497 8.706C21.0866 8.19416 21.0147 7.64893 20.75 7.19L20.53 6.81C20.2645 6.35154 19.8278 6.01717 19.316 5.88031C18.8042 5.74344 18.2589 5.81526 17.8 6.08L17.65 6.16C17.346 6.33554 17.0011 6.42795 16.65 6.42795C16.2989 6.42795 15.954 6.33554 15.65 6.16L15.22 5.91C14.9163 5.73464 14.664 5.48248 14.4885 5.17884C14.3129 4.87519 14.2204 4.53073 14.22 4.18V4C14.22 3.46957 14.0093 2.96086 13.6342 2.58579C13.2591 2.21071 12.7504 2 12.22 2Z"
                    stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                  <path
                    d="M12 15C13.6569 15 15 13.6569 15 12C15 10.3431 13.6569 9 12 9C10.3431 9 9 10.3431 9 12C9 13.6569 10.3431 15 12 15Z"
                    stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                </svg>
                Settings
              </button>
            </DialogTrigger>
            <DialogContent>
              <DialogHeader>
                <DialogTitle>
                  Settings
                </DialogTitle>
                <DialogDescription>
                  Make changes to your profile here and click done when your done.
                </DialogDescription>
              </DialogHeader>
              <div>

                <!--////////////////////-->
                <!--UPDATE USER SETTINGS-->
                <!--////////////////////-->

                <form class="flex flex-col w-[450px] justify-start" @submit.prevent="handleUpdate">
                  <FormField name="username">
                    <FormItem class="mb-3">
                      <FormLabel>Profile picture</FormLabel>
                      <FormControl>
                        <Input ref="uploadInput" id="picture" type="file" accept="image/jpg, image/jpeg, image/png, image/gif"
                          @change="selectFile" />
                      </FormControl>
                    </FormItem>

                    <FormItem>
                      <FormLabel>Name</FormLabel>
                      <FormControl>
                        <Input type="text" placeholder="John Doe"  v-model="userInfo.name"/>
                      </FormControl>
                    </FormItem>

                    <FormItem class="mt-4">
                      <FormLabel>Email</FormLabel>
                      <FormControl>
                        <Input type="email" placeholder="name@example.com" v-model="userInfo.email" />
                      </FormControl>
                    </FormItem>

                    <FormItem class="mt-4">
                      <FormLabel>Password</FormLabel>
                      <FormControl>
                        <Input type="password" placeholder="*************" v-model="userInfo.newPassword"/>
                      </FormControl>
                    </FormItem>

                    <FormItem class="mt-4">
                      <FormLabel>Confirm Password</FormLabel>
                      <FormControl>
                        <Input type="password" placeholder="*************"  v-model="userInfo.confirmNewPassword"/>
                      </FormControl>
                    </FormItem>
                    <p class="text-red-500" v-if="registrationErrors">{{ registrationErrorMsg }}</p>
                  </FormField>
                  <Button type="submit" class="mt-6 mx-[10%] py-2">
                    Done
                  </Button>
                 
                </form>

              </div>

            </DialogContent>
          </Dialog>

          <button v-on:click="logout" class="py-2 px-4 flex gap-3 w-[280px] rounded hover:bg-accent">
            <svg class="text-primary" width="24" height="24" viewBox="0 0 24 24" fill="none"
              xmlns="http://www.w3.org/2000/svg">
              <path
                d="M9 21H5C4.46957 21 3.96086 20.7893 3.58579 20.4142C3.21071 20.0391 3 19.5304 3 19V5C3 4.46957 3.21071 3.96086 3.58579 3.58579C3.96086 3.21071 4.46957 3 5 3H9"
                stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
              <path d="M16 17L21 12L16 7" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                stroke-linejoin="round" />
              <path d="M21 12H9" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
            </svg>
            Logout
          </button>
        </div>
      </nav>
    </div>
  </div>
</template>

<script>
import userService from "@/services/UserService";
import {
  Dialog,
  DialogContent,
  DialogDescription, DialogFooter,
  DialogHeader,
  DialogTitle,
  DialogTrigger
} from "@/components/ui/dialog";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Cropper } from 'vue-advanced-cropper'
import 'vue-advanced-cropper/dist/style.css';
import { Avatar, AvatarImage, AvatarFallback } from "@/components/ui/avatar";
import { Textarea } from "@/components/ui/textarea";
import { Accordion, AccordionContent, AccordionItem, AccordionTrigger } from "@/components/ui/accordion";
import { Label } from "@/components/ui/label";
import { Switch } from "@/components/ui/switch";
import postService from '../services/PostService';
import { RouterLink } from "vue-router";
import { toast, Toaster } from 'vue-sonner';
import {
  FormControl,
  FormField,
  FormItem,
  FormLabel,
} from '@/components/ui/form'


export default {
  components: {
    RouterLink,
    Toaster,
    Switch,
    Label,
    AccordionContent,
    AccordionTrigger,
    AccordionItem,
    Accordion,
    Textarea,
    Avatar,
    Input,
    FormControl,
    FormField,
    FormItem,
    FormLabel,
    DialogFooter,
    Cropper,
    Button, DialogDescription, DialogTitle, AvatarImage, AvatarFallback, DialogHeader, DialogContent, DialogTrigger, Dialog
  },
  data() {
    return {
      isShowModal: false,
      pic: null,
      post: {
        caption: '',
        altDescription: '',
      },
      userInfo:{
        name:'',
        email:'',
        newPassword:'',
        confirmNewPassword:''
      },
      registrationErrorMsg:'',
      registrationErrors:false
    }
  },
  props: ['show'],
  methods: {
    logout() {
      this.$router.push('/');
      this.$store.commit("TOGGLE_VALIDATION_STATUS");
      this.$store.commit("LOGOUT")
      // window.location.reload()
    },
    selectFile(event) {
      const files = event.target.files;
      if (!files.length) return;
      const reader = new FileReader();
      reader.onload = (e) => {
        this.pic = e.target.result;
        this.isShowModal = true; // Show modal with cropper
      };
      reader.readAsDataURL(files[0]);
    },
    showUpdateModal(){

      let currentUser = this.$store.state.user;
      this.userInfo.email = currentUser.email;
      this.userInfo.name = currentUser.name;
    },

    handleUpdate(e) {

      if (this.userInfo.name === ''){
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Please enter name.';
      }
      else if (this.userInfo.email === ''){
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Please enter email.';
      }
      else if (this.userInfo.newPassword === ''){
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Please enter password.';
      }
      else if (this.userInfo.confirmNewPassword === ''){
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Please confirm password.';
      }
      else if (this.userInfo.newPassword != this.userInfo.confirmNewPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {


        // if(this.pic){
        //   userService.updateUserAvatar(this.pic)
        //   .then(response => {
        //     if(response.status === 200){
        //       console.log('update avatar successful');
        //     }
        //   })
        //   .catch(err => console.log(err))
        // } 

        userService.updateUserInfo(this.userInfo)
        .then(response => {
            if(response.status === 200){
              console.log('update profile successful');
            }
          })
          .catch(err => console.log(err))
  
        // authService
        //   .register(this.user)
        //   .then((response) => {
        //     if (response.status === 201) {
        //       this.$store.commit("TOGGLE_VALIDATION_STATUS");
        //       this.$store.commit("SET_LOADING", false);
        //       this.$router.push({
        //         path: '/app',
        //         query: { registration: 'success' },
        //       });
        //     }
        //   })
        //   .catch((error) => {
        //     const response = error.response;
        //     this.registrationErrors = true;
        //     if (response.status === 400) {
        //       this.registrationErrorMsg = 'Bad Request: Validation Errors';
        //     }
        //   });
      }
      // if(this.pic){
      //   console.log(e.target)
      //   let img = e.target.files[0]
      //   const formData = new FormData(); 
      //   formData.append('image', img);
      //   userService.updateUserAvatar(formData)
      //   .then(response => {
      //     if(response.status === 200){
      //       console.log('update avatar successful');
      //     }
      //   })
      //   .catch(err => console.log(err))
      // } 

        // userService.updateUserInfo(this.userInfo)
        // .then(response => {
        //     if(response.status === 200){
        //       console.log('update profile successful');
        //     }
        //   })
        //   .catch(err => console.log(err))
    },
    handleSubmit() {
      const { canvas } = this.$refs.cropper.getResult();
      canvas.toBlob((blob) => {
        const formData = new FormData();
        formData.append('image', blob, 'cropped.jpg');
        formData.append('caption', this.post.caption);
        formData.append('alt_desc', this.post.altDescription);

        postService.post(formData).then(response => {
          if (response.status === 200) {
            toast('Picture uploaded successfully.');
            //after image upload the page gets reload which cause a user to log out automatically, that's why I commented out

            setTimeout(() => {
              window.location.reload();
            }, 100)

            // displaying the latest post to on the webpage, without leaving the webpage
            this.$store.commit('ADD_CREATED_POST_TO_POSTCOLLECTIONS', response.data);


            // Optionally emit an event or handle response
            console.log('Post created successfully!');
          } else {
            toast('Failed image upload.');
            console.error('Failed to create post.');
          }
        }).catch(error => {
          console.error('Error:', error);
        });
      });
    }
  }
}
</script>