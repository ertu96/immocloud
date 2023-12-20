package com.immocloud.backend.applicant;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicantService {

    private final ApplicantRepository applicantRepository;

    public ApplicantService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    public Optional<List<Applicant>> getApplicants(String nameFilter, boolean onlyAccepted) {
        return applicantRepository.findApplicantsByNameIsContainingIgnoreCaseAndStatusIsNot(nameFilter, onlyAccepted ? Status.DECLINED : null);
    }

    public void addApplicant(Applicant applicant) {
        applicant.setStatus(Status.OPEN);
        applicantRepository.save(applicant);
    }

    public void updateApplicationStatus(String applicantId, Status status) {
        Applicant applicant = applicantRepository.findById(applicantId).orElseThrow(() -> new RuntimeException("Applicant not found"));
        applicant.setStatus(status);
        applicantRepository.save(applicant);
    }
}
