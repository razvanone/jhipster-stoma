package com.stoma.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A Visit.
 */
@Entity
@Table(name = "visit")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Visit implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "created_date")
    private Instant createdDate;

    @Column(name = "updated_date")
    private Instant updatedDate;

    @Column(name = "target_date")
    private Instant targetDate;

    @Column(name = "duration_min")
    private Long durationMin;

    @Column(name = "patient_id")
    private Long patientId;

    @Column(name = "doctor_id")
    private Long doctorId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "cost")
    private Long cost;

    @ManyToOne
    @JsonIgnoreProperties(value = "visits", allowSetters = true)
    private Person patientId;

    @ManyToOne
    @JsonIgnoreProperties(value = "visits", allowSetters = true)
    private Person doctorId;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public Visit createdDate(Instant createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Instant getUpdatedDate() {
        return updatedDate;
    }

    public Visit updatedDate(Instant updatedDate) {
        this.updatedDate = updatedDate;
        return this;
    }

    public void setUpdatedDate(Instant updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Instant getTargetDate() {
        return targetDate;
    }

    public Visit targetDate(Instant targetDate) {
        this.targetDate = targetDate;
        return this;
    }

    public void setTargetDate(Instant targetDate) {
        this.targetDate = targetDate;
    }

    public Long getDurationMin() {
        return durationMin;
    }

    public Visit durationMin(Long durationMin) {
        this.durationMin = durationMin;
        return this;
    }

    public void setDurationMin(Long durationMin) {
        this.durationMin = durationMin;
    }

    public Long getPatientId() {
        return patientId;
    }

    public Visit patientId(Long patientId) {
        this.patientId = patientId;
        return this;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public Visit doctorId(Long doctorId) {
        this.doctorId = doctorId;
        return this;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getTitle() {
        return title;
    }

    public Visit title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public Visit description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCost() {
        return cost;
    }

    public Visit cost(Long cost) {
        this.cost = cost;
        return this;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Person getPatientId() {
        return patientId;
    }

    public Visit patientId(Person person) {
        this.patientId = person;
        return this;
    }

    public void setPatientId(Person person) {
        this.patientId = person;
    }

    public Person getDoctorId() {
        return doctorId;
    }

    public Visit doctorId(Person person) {
        this.doctorId = person;
        return this;
    }

    public void setDoctorId(Person person) {
        this.doctorId = person;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Visit)) {
            return false;
        }
        return id != null && id.equals(((Visit) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Visit{" +
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
            "}";
    }
}
