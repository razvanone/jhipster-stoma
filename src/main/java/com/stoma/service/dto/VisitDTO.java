package com.stoma.service.dto;

import java.time.Instant;
import java.io.Serializable;

/**
 * A DTO for the {@link com.stoma.domain.Visit} entity.
 */
public class VisitDTO implements Serializable {
    
    private Long id;

    private Instant createdDate;

    private Instant updatedDate;

    private Instant targetDate;

    private Long durationMin;

    private Long patientId;

    private Long doctorId;

    private String title;

    private String description;

    private Long cost;


    private Long patientIdId;

    private Long doctorIdId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Instant getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Instant updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Instant getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Instant targetDate) {
        this.targetDate = targetDate;
    }

    public Long getDurationMin() {
        return durationMin;
    }

    public void setDurationMin(Long durationMin) {
        this.durationMin = durationMin;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Long getPatientIdId() {
        return patientIdId;
    }

    public void setPatientIdId(Long personId) {
        this.patientIdId = personId;
    }

    public Long getDoctorIdId() {
        return doctorIdId;
    }

    public void setDoctorIdId(Long personId) {
        this.doctorIdId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VisitDTO)) {
            return false;
        }

        return id != null && id.equals(((VisitDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "VisitDTO{" +
            "id=" + getId() +
            ", createdDate='" + getCreatedDate() + "'" +
            ", updatedDate='" + getUpdatedDate() + "'" +
            ", targetDate='" + getTargetDate() + "'" +
            ", durationMin=" + getDurationMin() +
            ", patientId=" + getPatientId() +
            ", doctorId=" + getDoctorId() +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", cost=" + getCost() +
            ", patientIdId=" + getPatientIdId() +
            ", doctorIdId=" + getDoctorIdId() +
            "}";
    }
}
