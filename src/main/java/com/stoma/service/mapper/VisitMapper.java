package com.stoma.service.mapper;


import com.stoma.domain.*;
import com.stoma.service.dto.VisitDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Visit} and its DTO {@link VisitDTO}.
 */
@Mapper(componentModel = "spring", uses = {PatientMapper.class, UserMapper.class, MaterialMapper.class})
public interface VisitMapper extends EntityMapper<VisitDTO, Visit> {

    @Mapping(source = "patient.id", target = "patientId")
    @Mapping(source = "patient.lastName", target = "patientLastName")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.login", target = "userLogin")
    VisitDTO toDto(Visit visit);

    @Mapping(source = "patientId", target = "patient")
    @Mapping(source = "userId", target = "user")
    @Mapping(target = "removeMaterial", ignore = true)
    Visit toEntity(VisitDTO visitDTO);

    default Visit fromId(Long id) {
        if (id == null) {
            return null;
        }
        Visit visit = new Visit();
        visit.setId(id);
        return visit;
    }
}
