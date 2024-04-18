<template>
    <div class="self-stretch h-[308px] w-full bg-red-300 overflow-hidden rounded-md flex-col justify-center items-center gap-2.5 inline-flex">
      <img :src="pic" alt="test" loading="lazy" class="object-cover h-full min-w-full" />
    </div>
</template>

<script>
    export default{
      props: ['pic']
    }
</script>