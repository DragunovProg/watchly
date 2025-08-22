package ua.dragunov.watchlyapi.mapper;

import org.mapstruct.Mapper; // 1. Добавь этот импорт
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ua.dragunov.watchlyapi.dto.UserCreateRequest;
import ua.dragunov.watchlyapi.dto.UserResponse;
import ua.dragunov.watchlyapi.dto.UserUpdateRequest;
import ua.dragunov.watchlyapi.model.User;

@Mapper(componentModel = "spring"
        , nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    @Mapping(target = "password", ignore = true)
    User toUser(UserCreateRequest registerRequest);

    @Mapping(target = "firstName", source = "update.firstName")
    @Mapping(target = "lastName", source = "update.lastName")
    @Mapping(target = "gender", source = "update.gender")
    @Mapping(target = "birthday", source = "update.birthday")
    User toUser(UserUpdateRequest update, @MappingTarget User user);

    UserResponse toUserResponse(User user);

}