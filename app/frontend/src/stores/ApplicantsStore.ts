import axios from "axios";
import { defineStore } from "pinia";
import { Status } from "../enums/Status";
import { Applicant } from "../interfaces/Applicant";
import { useFilterStore } from "./FilterStore";

export const useApplicantsStore = defineStore("applicants", {
  state: () => ({
    applicants: [] as Applicant[],
  }),
  getters: {
    getApplicants(): Applicant[] {
      return this.applicants;
    },
  },
  actions: {
    async fetchApplicants(name: String, onlyAccepted: boolean) {
      const response = await axios.get(
        `/api/applicant?name=${name}&onlyAccepted=${onlyAccepted}`
      );
      this.applicants = await response.data;
    },

    async createApplicant(form: { name: string }) {
      await axios.post("/api/applicant", form);
      useFilterStore().setFilter({
        name: "",
        onlyAccepted: false,
      });
    },

    async updateApplicationStatus(id: string, status: Status) {
      await axios.put(`/api/applicant/${id}?status=${status}`);
      useFilterStore().setFilter({
        name: "",
        onlyAccepted: false,
      });
    },
  },
});
