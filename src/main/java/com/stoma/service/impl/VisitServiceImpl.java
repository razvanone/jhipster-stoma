package com.stoma.service.impl;

import com.stoma.service.VisitService;
import com.stoma.domain.Visit;
import com.stoma.repository.VisitRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Visit}.
 */
@Service
@Transactional
public class VisitServiceImpl implements VisitService {

    private final Logger log = LoggerFactory.getLogger(VisitServiceImpl.class);

    private final VisitRepository visitRepository;

    public VisitServiceImpl(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Visit save(Visit visit) {
        log.debug("Request to save Visit : {}", visit);
        return visitRepository.save(visit);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Visit> findAll() {
        log.debug("Request to get all Visits");
        return visitRepository.findAll();
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<Visit> findOne(Long id) {
        log.debug("Request to get Visit : {}", id);
        return visitRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Visit : {}", id);
        visitRepository.deleteById(id);
    }
}
