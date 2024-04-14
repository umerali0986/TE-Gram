<template>
    <div>
        <h1>This is {{ user.username }}'s profile!</h1>
        <div>
            These are {{ user.username }}'s photos! 
        </div>
    </div>
</template>

<script>

    import userService from '@/services/UserService';

    export default{

        data(){
            return {
                user: {}
            }
        },
        created(){
            userService.getUserByUsername(this.$route.params.username)
            .then(res => {
                this.user = res.data;
            })
        }
    }
</script>