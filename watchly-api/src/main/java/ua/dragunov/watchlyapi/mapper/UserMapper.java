package ua.dragunov.watchlyapi.mapper;

import org.mapstruct.Mapper; // 1. Добавь этот импорт
import org.mapstruct.Mapping;
import ua.dragunov.watchlyapi.dto.UserCreateRequest;
import ua.dragunov.watchlyapi.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "password", ignore = true)
    User toUser(UserCreateRequest registerRequest);

}