<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
  name: "Button",
  props: {
    type: {
      type: String as () => "button" | "submit" | "reset" | undefined,
      default: "button",
      required: false,
    },
    text: {
      type: String,
      required: true,
    },
    class: {
      type: String,
      default: "btn",
      required: false,
    },
  },
});
</script>

<template>
  <button :type="type" :class="class">{{ text }}</button>
</template>
