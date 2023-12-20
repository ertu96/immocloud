<script lang="ts">
import { mapStores } from "pinia";
import { defineComponent } from "vue";
import { useFilterStore } from "../../stores/FilterStore";
import Divider from "../ui/layout/Divider.vue";

export default defineComponent({
  name: "InputFilters",
  computed: {
    ...mapStores(useFilterStore),
  },
  data: () => ({
    nameFilter: "",
    onlyAcceptedFilter: false,
  }),
  methods: {
    changeFilter() {
      this.filterStore.setFilter({
        name: this.nameFilter,
        onlyAccepted: this.onlyAcceptedFilter,
      });
    },
  },
  components: { Divider },
});
</script>

<template>
  <div class="flex gap-2">
    <label class="form-control w-full max-w-xs">
      <input
        type="text"
        placeholder="Namensfilter"
        class="input input-bordered w-full max-w-xs"
        v-model.lazy="nameFilter"
        @change="changeFilter"
      />
    </label>
    <Divider orientation="horizontal" />
    <div class="form-control">
      <label class="label cursor-pointer">
        <span class="label-text">Abgelehnte Bewerber ausblenden</span>
        <input
          type="checkbox"
          class="checkbox"
          v-model="onlyAcceptedFilter"
          @change="changeFilter"
        />
      </label>
    </div>
  </div>
</template>
