<template>
    <div class="flex ">
        <div>
            <img :src="post.path">
        </div>

        <div>
            <div class="bg-black"></div>
        </div>
    </div>
</template>

<script>

export default {

    data() {
        return {
            post: this.$store.state.imageCollections[this.$route.params.id-1]
        }
    }

}
</script>