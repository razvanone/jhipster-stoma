package com.stoma.service.dto;

import java.time.Instant;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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


    private Long patientId;

    private String patientLastName;
    private Set<MaterialDTO> materials = new HashSet<>();
    
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

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public Set<MaterialDTO> getMaterials() {
        return materials;
    }

    public void setMaterials(Set<MaterialDTO> materials) {
        this.materials = materials;
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
            ", patientId=" + getPatientId() +
            ", patientLastName='" + getPatientLastName() + "'" +
            ", materials='" + getMaterials() + "'" +
            "}";
    }
}
