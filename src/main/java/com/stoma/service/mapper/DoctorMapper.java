package com.stoma.service.mapper;


import com.stoma.domain.*;
import com.stoma.service.dto.DoctorDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Doctor} and its DTO {@link DoctorDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DoctorMapper extends EntityMapper<DoctorDTO, Doctor> {


    @Mapping(target = "addresses", ignore = true)
    @Mapping(target = "removeAddress", ignore = true)
    @Mapping(target = "visits", ignore = true)
    @Mapping(target = "removeVisit", ignore = true)
    Doctor toEntity(DoctorDTO doctorDTO);

    default Doctor fromId(Long id) {
        if (id == null) {
            return null;
        }
        Doctor doctor = new Doctor();
        doctor.setId(id);
        return doctor;
    }
}
