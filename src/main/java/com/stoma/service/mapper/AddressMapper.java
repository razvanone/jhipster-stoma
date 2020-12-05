package com.stoma.service.mapper;


import com.stoma.domain.*;
import com.stoma.service.dto.AddressDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Address} and its DTO {@link AddressDTO}.
 */
@Mapper(componentModel = "spring", uses = {PersonMapper.class, DoctorMapper.class})
public interface AddressMapper extends EntityMapper<AddressDTO, Address> {

    @Mapping(source = "person.id", target = "personId")
    @Mapping(source = "doctor.id", target = "doctorId")
    AddressDTO toDto(Address address);

    @Mapping(source = "personId", target = "person")
    @Mapping(source = "doctorId", target = "doctor")
    Address toEntity(AddressDTO addressDTO);

    default Address fromId(Long id) {
        if (id == null) {
            return null;
        }
        Address address = new Address();
        address.setId(id);
        return address;
    }
}
