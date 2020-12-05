package com.stoma.service;

import com.stoma.service.dto.MaterialDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.stoma.domain.Material}.
 */
public interface MaterialService {

    /**
     * Save a material.
     *
     * @param materialDTO the entity to save.
     * @return the persisted entity.
     */
    MaterialDTO save(MaterialDTO materialDTO);

    /**
     * Get all the materials.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<MaterialDTO> findAll(Pageable pageable);


    /**
     * Get the "id" material.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<MaterialDTO> findOne(Long id);

    /**
     * Delete the "id" material.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
