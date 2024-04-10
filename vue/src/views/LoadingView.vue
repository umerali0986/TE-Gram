<template>
  <div v-show="loading" class="sticky bg-white z-20 w-screen h-screen bg-background flex items-center justify-center">
    <div class="w-[400px] flex flex-col gap-2">
      <Progress :model-value="progressValue" />
      <div class="w-full flex justify-end text-foreground/50">
        <span>Loading..</span>
      </div>
    </div>
  </div>
</template>

<script>
import { Progress } from "@/components/ui/progress"
import { ref, computed, watch } from 'vue'
import { useStore } from 'vuex'

export default {
  components: {
    Progress
  },
  setup() {
    const store = useStore()
    const progressValue = ref(0)

    // Use computed to reactively track the loading state from Vuex
    const loading = computed(() => store.state.loading)

    // Start progress animation and watch for loading changes
    const startProgress = () => {
      const interval = 100; // Adjust this for faster or slower progress
      const step = 30; // Progress increase per interval, adjust for granularity

      const intervalId = setInterval(() => {
        // Stop if loading is false or progressValue reaches 100
        if (!loading.value || progressValue.value >= 100) {
          clearInterval(intervalId)
        } else {
          progressValue.value += step
        }
      }, interval)
    }

    // Start the progress when the component is mounted
    startProgress()

    // Watch for loading to be false to immediately set progress to 100
    watch(loading, (newValue) => {
      if (!newValue) {
        progressValue.value = 100
      }
    })

    return { progressValue, loading }
  }
}
</script>
