<script setup lang="ts">
import ApplicantForm from "../components/applicant-form/ApplicantForm.vue";
import ApplicantsTable from "../components/applicants-table/ApplicantsTable.vue";
import InputFilters from "../components/input-filters/InputFilters.vue";
import Divider from "../components/ui/layout/Divider.vue";
</script>

<template>
  <ApplicantForm />
  <Divider />
  <InputFilters />
  <ApplicantsTable />
</template>
