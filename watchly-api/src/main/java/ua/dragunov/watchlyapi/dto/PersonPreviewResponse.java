package ua.dragunov.watchlyapi.dto;

import ua.dragunov.watchlyapi.model.PersonRoleType;

import java.util.UUID;

public record PersonPreviewResponse(
        UUID id,
        String fullName,
        String photoUrl,
        PersonRoleType roleType
){}
