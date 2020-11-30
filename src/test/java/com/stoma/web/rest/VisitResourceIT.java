package com.stoma.web.rest;

import com.stoma.StomaApp;
import com.stoma.domain.Visit;
import com.stoma.repository.VisitRepository;
import com.stoma.service.VisitService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link VisitResource} REST controller.
 */
@SpringBootTest(classes = StomaApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class VisitResourceIT {

    private static final Instant DEFAULT_START_TIME = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_START_TIME = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_DURATION_MIN = 1L;
    private static final Long UPDATED_DURATION_MIN = 2L;

    private static final Boolean DEFAULT_COMPLETED = false;
    private static final Boolean UPDATED_COMPLETED = true;

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final String DEFAULT_COMMENTS = "AAAAAAAAAA";
    private static final String UPDATED_COMMENTS = "BBBBBBBBBB";

    private static final Long DEFAULT_COST = 1L;
    private static final Long UPDATED_COST = 2L;

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private VisitService visitService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restVisitMockMvc;

    private Visit visit;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Visit createEntity(EntityManager em) {
        Visit visit = new Visit()
            .startTime(DEFAULT_START_TIME)
            .durationMin(DEFAULT_DURATION_MIN)
            .completed(DEFAULT_COMPLETED)
            .description(DEFAULT_DESCRIPTION)
            .comments(DEFAULT_COMMENTS)
            .cost(DEFAULT_COST);
        return visit;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Visit createUpdatedEntity(EntityManager em) {
        Visit visit = new Visit()
            .startTime(UPDATED_START_TIME)
            .durationMin(UPDATED_DURATION_MIN)
            .completed(UPDATED_COMPLETED)
            .description(UPDATED_DESCRIPTION)
            .comments(UPDATED_COMMENTS)
            .cost(UPDATED_COST);
        return visit;
    }

    @BeforeEach
    public void initTest() {
        visit = createEntity(em);
    }

    @Test
    @Transactional
    public void createVisit() throws Exception {
        int databaseSizeBeforeCreate = visitRepository.findAll().size();
        // Create the Visit
        restVisitMockMvc.perform(post("/api/visits")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(visit)))
            .andExpect(status().isCreated());

        // Validate the Visit in the database
        List<Visit> visitList = visitRepository.findAll();
        assertThat(visitList).hasSize(databaseSizeBeforeCreate + 1);
        Visit testVisit = visitList.get(visitList.size() - 1);
        assertThat(testVisit.getStartTime()).isEqualTo(DEFAULT_START_TIME);
        assertThat(testVisit.getDurationMin()).isEqualTo(DEFAULT_DURATION_MIN);
        assertThat(testVisit.isCompleted()).isEqualTo(DEFAULT_COMPLETED);
        assertThat(testVisit.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testVisit.getComments()).isEqualTo(DEFAULT_COMMENTS);
        assertThat(testVisit.getCost()).isEqualTo(DEFAULT_COST);
    }

    @Test
    @Transactional
    public void createVisitWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = visitRepository.findAll().size();

        // Create the Visit with an existing ID
        visit.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restVisitMockMvc.perform(post("/api/visits")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(visit)))
            .andExpect(status().isBadRequest());

        // Validate the Visit in the database
        List<Visit> visitList = visitRepository.findAll();
        assertThat(visitList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllVisits() throws Exception {
        // Initialize the database
        visitRepository.saveAndFlush(visit);

        // Get all the visitList
        restVisitMockMvc.perform(get("/api/visits?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(visit.getId().intValue())))
            .andExpect(jsonPath("$.[*].startTime").value(hasItem(DEFAULT_START_TIME.toString())))
            .andExpect(jsonPath("$.[*].durationMin").value(hasItem(DEFAULT_DURATION_MIN.intValue())))
            .andExpect(jsonPath("$.[*].completed").value(hasItem(DEFAULT_COMPLETED.booleanValue())))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION)))
            .andExpect(jsonPath("$.[*].comments").value(hasItem(DEFAULT_COMMENTS)))
            .andExpect(jsonPath("$.[*].cost").value(hasItem(DEFAULT_COST.intValue())));
    }
    
    @Test
    @Transactional
    public void getVisit() throws Exception {
        // Initialize the database
        visitRepository.saveAndFlush(visit);

        // Get the visit
        restVisitMockMvc.perform(get("/api/visits/{id}", visit.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(visit.getId().intValue()))
            .andExpect(jsonPath("$.startTime").value(DEFAULT_START_TIME.toString()))
            .andExpect(jsonPath("$.durationMin").value(DEFAULT_DURATION_MIN.intValue()))
            .andExpect(jsonPath("$.completed").value(DEFAULT_COMPLETED.booleanValue()))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION))
            .andExpect(jsonPath("$.comments").value(DEFAULT_COMMENTS))
            .andExpect(jsonPath("$.cost").value(DEFAULT_COST.intValue()));
    }
    @Test
    @Transactional
    public void getNonExistingVisit() throws Exception {
        // Get the visit
        restVisitMockMvc.perform(get("/api/visits/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateVisit() throws Exception {
        // Initialize the database
        visitService.save(visit);

        int databaseSizeBeforeUpdate = visitRepository.findAll().size();

        // Update the visit
        Visit updatedVisit = visitRepository.findById(visit.getId()).get();
        // Disconnect from session so that the updates on updatedVisit are not directly saved in db
        em.detach(updatedVisit);
        updatedVisit
            .startTime(UPDATED_START_TIME)
            .durationMin(UPDATED_DURATION_MIN)
            .completed(UPDATED_COMPLETED)
            .description(UPDATED_DESCRIPTION)
            .comments(UPDATED_COMMENTS)
            .cost(UPDATED_COST);

        restVisitMockMvc.perform(put("/api/visits")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedVisit)))
            .andExpect(status().isOk());

        // Validate the Visit in the database
        List<Visit> visitList = visitRepository.findAll();
        assertThat(visitList).hasSize(databaseSizeBeforeUpdate);
        Visit testVisit = visitList.get(visitList.size() - 1);
        assertThat(testVisit.getStartTime()).isEqualTo(UPDATED_START_TIME);
        assertThat(testVisit.getDurationMin()).isEqualTo(UPDATED_DURATION_MIN);
        assertThat(testVisit.isCompleted()).isEqualTo(UPDATED_COMPLETED);
        assertThat(testVisit.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testVisit.getComments()).isEqualTo(UPDATED_COMMENTS);
        assertThat(testVisit.getCost()).isEqualTo(UPDATED_COST);
    }

    @Test
    @Transactional
    public void updateNonExistingVisit() throws Exception {
        int databaseSizeBeforeUpdate = visitRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restVisitMockMvc.perform(put("/api/visits")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(visit)))
            .andExpect(status().isBadRequest());

        // Validate the Visit in the database
        List<Visit> visitList = visitRepository.findAll();
        assertThat(visitList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteVisit() throws Exception {
        // Initialize the database
        visitService.save(visit);

        int databaseSizeBeforeDelete = visitRepository.findAll().size();

        // Delete the visit
        restVisitMockMvc.perform(delete("/api/visits/{id}", visit.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Visit> visitList = visitRepository.findAll();
        assertThat(visitList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
