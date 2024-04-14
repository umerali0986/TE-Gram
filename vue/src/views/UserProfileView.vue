<template>
    <div>
        <h1>This is {{ user.username }}'s profile!</h1>
        <div v-if="userPosts[0] !== ''">
            These are {{ user.username }}'s photos! 
            <PostCard v-for="(post, index) in userPosts" :key="index" :post="post"></PostCard>
        </div>
    </div>
</template>

<script>

    import userService from '@/services/UserService';
    import postService from '../services/PostService';
    import PostCard from '@/components/PostCard.vue';
    import axios from 'axios';

    export default{

        data(){
            return {
                user: {},
                userPosts: {}
            }
        },
        components: {
            PostCard
        },
        created(){
            userService.getUserByUsername(this.$route.params.username)
            .then(res => {
                this.user = res.data;
            }).catch(err => console.log(err));

            postService.getPostsByUsername(this.$route.params.username)
            .then(res => {
                this.userPosts = res.data; 
            }).catch(err => console.log(err));
        }
    }
</script>