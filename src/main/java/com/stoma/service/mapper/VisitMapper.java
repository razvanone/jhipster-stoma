package com.stoma.service.mapper;


import com.stoma.domain.*;
import com.stoma.service.dto.VisitDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Visit} and its DTO {@link VisitDTO}.
 */
@Mapper(componentModel = "spring", uses = {PersonMapper.class})
public interface VisitMapper extends EntityMapper<VisitDTO, Visit> {

    @Mapping(source = "patientId.id", target = "patientIdId")
    @Mapping(source = "doctorId.id", target = "doctorIdId")
    VisitDTO toDto(Visit visit);

    @Mapping(source = "patientIdId", target = "patientId")
    @Mapping(source = "doctorIdId", target = "doctorId")
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
