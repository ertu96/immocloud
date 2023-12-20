package com.immocloud.backend.applicant;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/applicant")
public class ApplicantController {

    private final ApplicantService applicantService;

    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @GetMapping
    public Optional<List<Applicant>> getApplicants(@RequestParam String name, @RequestParam boolean onlyAccepted) {
        return applicantService.getApplicants(name, onlyAccepted);
    }

    @PostMapping
    public void addApplicant(@RequestBody Applicant applicant) {
        applicantService.addApplicant(applicant);
    }

    @PutMapping(path = "{applicantId}")
    public void updateApplicationStatus(@PathVariable("applicantId") String applicantId, @RequestParam("status") Status status) {
        applicantService.updateApplicationStatus(applicantId, status);
    }

}
