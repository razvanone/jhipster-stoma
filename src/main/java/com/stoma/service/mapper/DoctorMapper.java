package com.stoma.service.mapper;


import com.stoma.domain.*;
import com.stoma.service.dto.DoctorDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Doctor} and its DTO {@link DoctorDTO}.
 */
@Mapper(componentModel = "spring", uses = {AddressMapper.class})
public interface DoctorMapper extends EntityMapper<DoctorDTO, Doctor> {

    @Mapping(source = "address.id", target = "addressId")
    DoctorDTO toDto(Doctor doctor);

    @Mapping(target = "visits", ignore = true)
    @Mapping(target = "removeVisit", ignore = true)
    @Mapping(source = "addressId", target = "address")
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
