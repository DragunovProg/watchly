package ua.dragunov.watchlyapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.dragunov.watchlyapi.dto.PersonPreviewResponse;
import ua.dragunov.watchlyapi.model.MediaPersonRole;
import ua.dragunov.watchlyapi.model.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(source = "person.id", target = "id")
    @Mapping(source = "person.fullName", target = "fullName")
    @Mapping(source = "person.photoUrl", target = "photoUrl")
    @Mapping(source = "personRoleType", target = "roleType")
    public PersonPreviewResponse toPreview(MediaPersonRole person);
}
