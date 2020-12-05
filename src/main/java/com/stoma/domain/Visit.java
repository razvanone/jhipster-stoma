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

    @Column(name = "start_time")
    private Instant startTime;

    @Column(name = "duration_min")
    private Long durationMin;

    @Column(name = "completed")
    private Boolean completed;

    @Column(name = "description")
    private String description;

    @Column(name = "comments")
    private String comments;

    @Column(name = "cost")
    private Long cost;

    @ManyToOne
    @JsonIgnoreProperties(value = "visits", allowSetters = true)
    private Person person;

    @ManyToOne
    @JsonIgnoreProperties(value = "visits", allowSetters = true)
    private Doctor doctor;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public Visit startTime(Instant startTime) {
        this.startTime = startTime;
        return this;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
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

    public Boolean isCompleted() {
        return completed;
    }

    public Visit completed(Boolean completed) {
        this.completed = completed;
        return this;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
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

    public String getComments() {
        return comments;
    }

    public Visit comments(String comments) {
        this.comments = comments;
        return this;
    }

    public void setComments(String comments) {
        this.comments = comments;
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

    public Person getPerson() {
        return person;
    }

    public Visit person(Person person) {
        this.person = person;
        return this;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Visit doctor(Doctor doctor) {
        this.doctor = doctor;
        return this;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
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
            ", startTime='" + getStartTime() + "'" +
            ", durationMin=" + getDurationMin() +
            ", completed='" + isCompleted() + "'" +
            ", description='" + getDescription() + "'" +
            ", comments='" + getComments() + "'" +
            ", cost=" + getCost() +
            "}";
    }
}
