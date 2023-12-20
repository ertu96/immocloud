import { defineStore } from "pinia";
import { useApplicantsStore } from "./ApplicantsStore";

export const useFilterStore = defineStore("filter", {
  state: () => ({
    name: "",
    onlyAccepted: false,
  }),
  getters: {
    getFilter(): { name: string; onlyAccepted: boolean } {
      return {
        name: this.name,
        onlyAccepted: this.onlyAccepted,
      };
    },
  },
  actions: {
    setFilter(filter: { name: string; onlyAccepted: boolean }) {
      this.name = filter.name;
      this.onlyAccepted = filter.onlyAccepted;
      useApplicantsStore().fetchApplicants(filter.name, filter.onlyAccepted);
    },
  },
});
