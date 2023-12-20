package com.immocloud.backend.applicant;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ApplicantRepository extends MongoRepository<Applicant, String> {

    Optional<List<Applicant>> findApplicantsByNameIsContainingIgnoreCaseAndStatusIsNot(String name, Status status);
}
