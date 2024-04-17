<template>
    <DropdownMenu>
      <DropdownMenuTrigger as-child>
        <button>
           <svg class="text-primary" width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
             <path d="M12 13C12.5523 13 13 12.5523 13 12C13 11.4477 12.5523 11 12 11C11.4477 11 11 11.4477 11 12C11 12.5523 11.4477 13 12 13Z" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
             <path d="M19 13C19.5523 13 20 12.5523 20 12C20 11.4477 19.5523 11 19 11C18.4477 11 18 11.4477 18 12C18 12.5523 18.4477 13 19 13Z" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
             <path d="M5 13C5.55228 13 6 12.5523 6 12C6 11.4477 5.55228 11 5 11C4.44772 11 4 11.4477 4 12C4 12.5523 4.44772 13 5 13Z" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
           </svg>
        </button>
      </DropdownMenuTrigger>
      <DropdownMenuContent class="w-56">
        <DropdownMenuLabel>Actions</DropdownMenuLabel>
        <DropdownMenuSeparator />
        <DropdownMenuCheckboxItem @click="handleDelete(post.id)" v-if="post.postCreator === this.$store.state.user.username">
          <span class="text-red-500">Delete Post</span>
        </DropdownMenuCheckboxItem>
        <DropdownMenuCheckboxItem>
          Add Function
        </DropdownMenuCheckboxItem>
        <DropdownMenuCheckboxItem>
          Add Function
        </DropdownMenuCheckboxItem>
      </DropdownMenuContent>
    </DropdownMenu>
  </template>

<script>
    import postService from '@/services/PostService';
    import {
        DropdownMenu,
        DropdownMenuCheckboxItem,
        DropdownMenuContent,
        DropdownMenuLabel,
        DropdownMenuSeparator,
        DropdownMenuTrigger,
    } from '@/components/ui/dropdown-menu'

    export default {
        data(){
            return {
                
            }
        },
        methods: {
            handleDelete(postId){
                postService.deletePostById(postId)
                    .then(response => {
                        if(response.status === 204){
                            console.log("delete successful");
                            if(this.$route.path === '/app'){
                                this.$router.go();
                            } else {
                                this.$router.push('/app');
                            }
                        }
                    })
                    .catch(err => console.log(err));
            }
        },
        props: ['post'],
        components: {
            DropdownMenu,
            DropdownMenuCheckboxItem,
            DropdownMenuContent,
            DropdownMenuLabel,
            DropdownMenuSeparator,
            DropdownMenuTrigger
        }
    }
</script>