package com.stoma.service.mapper;


import com.stoma.domain.*;
import com.stoma.service.dto.PersonDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Person} and its DTO {@link PersonDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PersonMapper extends EntityMapper<PersonDTO, Person> {


    @Mapping(target = "addresses", ignore = true)
    @Mapping(target = "removeAddress", ignore = true)
    @Mapping(target = "visits", ignore = true)
    @Mapping(target = "removeVisit", ignore = true)
    Person toEntity(PersonDTO personDTO);

    default Person fromId(Long id) {
        if (id == null) {
            return null;
        }
        Person person = new Person();
        person.setId(id);
        return person;
    }
}
