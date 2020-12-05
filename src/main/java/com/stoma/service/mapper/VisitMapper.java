package com.stoma.service.mapper;


import com.stoma.domain.*;
import com.stoma.service.dto.VisitDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Visit} and its DTO {@link VisitDTO}.
 */
@Mapper(componentModel = "spring", uses = {PersonMapper.class, DoctorMapper.class})
public interface VisitMapper extends EntityMapper<VisitDTO, Visit> {

    @Mapping(source = "person.id", target = "personId")
    @Mapping(source = "doctor.id", target = "doctorId")
    VisitDTO toDto(Visit visit);

    @Mapping(source = "personId", target = "person")
    @Mapping(source = "doctorId", target = "doctor")
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
