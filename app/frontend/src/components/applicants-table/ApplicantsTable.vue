<script lang="ts">
import { mapStores } from "pinia";
import { defineComponent } from "vue";
import { Status } from "../../enums/Status";
import { useApplicantsStore } from "../../stores/ApplicantsStore";
import { useFilterStore } from "../../stores/FilterStore";
import Button from "../ui/actions/Button.vue";

export default defineComponent({
  name: "ApplicantsTable",
  computed: {
    ...mapStores(useApplicantsStore, useFilterStore),
  },
  methods: {
    getStatusName(status: Status) {
      switch (status) {
        case Status.OPEN:
          return "Offen";
        case Status.ACCEPTED:
          return "Angenommen";
        case Status.DECLINED:
          return "Abgelehnt";
      }
    },
  },
  mounted() {
    this.filterStore.setFilter({
      name: "",
      onlyAccepted: false,
    });
  },
  setup() {
    return { Status };
  },
  components: { Button },
});
</script>

<template>
  <div class="overflow-x-auto">
    <table class="table">
      <thead>
        <tr>
          <th>Name</th>
          <th>Status</th>
          <th>Aktion</th>
        </tr>
      </thead>
      <tbody>
        <tr
          class="bg-base-200"
          v-for="applicant in applicantsStore.applicants"
          :key="applicant.id"
        >
          <td>{{ applicant.name }}</td>
          <td>{{ getStatusName(applicant.status) }}</td>
          <td>
            <div class="join" v-if="applicant.status === Status.OPEN">
              <Button
                class="btn join-item btn-success btn-outline btn-xs"
                @click="
                  applicantsStore.updateApplicationStatus(
                    applicant.id,
                    Status.ACCEPTED
                  )
                "
                text="Annehmen"
              />
              <Button
                class="btn join-item btn-error btn-outline btn-xs"
                @click="
                  applicantsStore.updateApplicationStatus(
                    applicant.id,
                    Status.DECLINED
                  )
                "
                text="Ablehnen"
              />
            </div>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>
