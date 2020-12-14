package com.stoma.repository;

import com.stoma.domain.Patient;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the Patient entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("select patient from Patient patient where patient.user.login = ?#{principal.username}")
    List<Patient> findByUserIsCurrentUser();
}
