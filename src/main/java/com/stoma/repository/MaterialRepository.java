package com.stoma.repository;

import com.stoma.domain.Material;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the Material entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {

    @Query("select material from Material material where material.user.login = ?#{principal.username}")
    List<Material> findByUserIsCurrentUser();
}
