<template>
  <div class="live-demo">
    <!-- Select a picture for cropping -->
    <section class="section">
      <p>{{ locales.tips }}</p>

      <!-- Set a button that invokes selecting an image -->
      <button class="select-picture">
        <span>{{ locales.selectPictureButtonText }}</span>
        <input
            ref="uploadInput"
            type="file"
            accept="image/jpg, image/jpeg, image/png, image/gif"
            @change="selectFile"
        />
      </button>
    </section>

    <!-- Crop result preview -->
    <section class="section" v-if="result.dataURL && result.blobURL">
      <p>{{ locales.previewTips.dataURL }}</p>
      <div class="preview">
        <img :src="result.dataURL" />
      </div>
      <p>{{ locales.previewTips.blob }}</p>
      <div class="preview">
        <img :src="result.blobURL" />
      </div>
      <p>{{ locales.previewTips.print }}</p>
    </section>

    <!-- A Popup for cropping -->
    <!-- You can replace it with the framework's Modal component -->

  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue'
import VuePictureCropper, { cropper } from 'vue-picture-cropper'
// Only used in demo
import { getLocales } from '../locales/live-demo'

export default defineComponent({
  components: {
    VuePictureCropper,
  },
  data() {
    return {
      locales: getLocales(),
      isShowModal: false,
      pic: '',
      result: {
        dataURL: '',
        blobURL: '',
      },
    }
  },
  methods: {
    /**
     * Select the picture to be cropped
     */
    selectFile(e: Event) {
      // Reset last selection and results
      this.pic = ''
      this.result.dataURL = ''
      this.result.blobURL = ''

      // Get selected files
      const { files } = e.target as HTMLInputElement
      if (!files || !files.length) return

      // Convert to dataURL and pass to the cropper component
      const file = files[0]
      const reader = new FileReader()
      reader.readAsDataURL(file)
      reader.onload = () => {
        // Update the picture source of the `img` prop
        this.pic = String(reader.result)

        // Show the modal
        this.isShowModal = true

        // Clear selected files of input element
        if (!this.$refs.uploadInput) return
        this.$refs.uploadInput.value = ''
      }
    },

    /**
     * Get cropping results
     */
    async getResult() {
      if (!cropper) return
      const base64 = cropper.getDataURL()
      const blob: Blob | null = await cropper.getBlob()
      if (!blob) return

      const file = await cropper.getFile({
        fileName: this.locales.fileName,
      })

      console.log({ base64, blob, file })
      this.result.dataURL = base64
      this.result.blobURL = URL.createObjectURL(blob)
      this.isShowModal = false
    },

    /**
     * Clear the crop box
     */
    clear() {
      if (!cropper) return
      cropper.clear()
    },

    /**
     * Reset the default cropping area
     */
    reset() {
      if (!cropper) return
      cropper.reset()
    },

    /**
     * The ready event passed to Cropper.js
     */
    ready() {
      console.log('Cropper is ready.')
    },
  },
})
</script>

<style lang="less" scoped>
@import '../styles/live-demo.less';
</style>