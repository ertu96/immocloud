<script lang="ts">
import { mapStores } from "pinia";
import { defineComponent } from "vue";
import { useApplicantsStore } from "../../stores/ApplicantsStore";
import Button from "../ui/actions/Button.vue";

export default defineComponent({
  name: "ApplicationForm",
  components: {
    Button,
  },
  computed: {
    ...mapStores(useApplicantsStore),
  },
  data: () => ({
    form: {
      name: "",
    },
  }),
  methods: {
    async submit(e: Event) {
      e.preventDefault();
      try {
        await this.applicantsStore.createApplicant(this.form);
      } catch (e) {
        console.error(e);
      } finally {
        this.form = {
          name: "",
        };
      }
    },
  },
});
</script>

<template>
  <form class="flex gap-2 items-end" :onSubmit="submit" action="">
    <label class="form-control w-full max-w-xs">
      <div class="label">
        <span class="label-text">Name</span>
      </div>
      <input
        v-model.lazy="form.name"
        type="text"
        placeholder="Vor-und Nachname"
        class="input input-bordered w-full max-w-xs"
      />
    </label>
    <Button type="submit" text="Hinzufügen" />
  </form>
</template>
