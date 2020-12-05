package com.stoma.service.dto;

import java.time.Instant;
import java.io.Serializable;

/**
 * A DTO for the {@link com.stoma.domain.Visit} entity.
 */
public class VisitDTO implements Serializable {
    
    private Long id;

    private Instant startTime;

    private Long durationMin;

    private Boolean completed;

    private String description;

    private String comments;

    private Long cost;


    private Long personId;

    private Long doctorId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Long getDurationMin() {
        return durationMin;
    }

    public void setDurationMin(Long durationMin) {
        this.durationMin = durationMin;
    }

    public Boolean isCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
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
            ", startTime='" + getStartTime() + "'" +
            ", durationMin=" + getDurationMin() +
            ", completed='" + isCompleted() + "'" +
            ", description='" + getDescription() + "'" +
            ", comments='" + getComments() + "'" +
            ", cost=" + getCost() +
            ", personId=" + getPersonId() +
            ", doctorId=" + getDoctorId() +
            "}";
    }
}
