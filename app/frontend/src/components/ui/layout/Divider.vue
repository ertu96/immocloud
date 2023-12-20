<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
  name: "Divider",
  props: {
    orientation: {
      type: String as () => "horizontal" | "vertical",
      default: "vertical",
      required: false,
    },
  },
});
</script>

<template>
  <div
    :class="`divider ${orientation === 'horizontal' && 'divider-horizontal'}`"
  />
</template>
