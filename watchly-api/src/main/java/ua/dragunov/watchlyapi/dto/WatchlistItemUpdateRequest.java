package ua.dragunov.watchlyapi.dto;

import ua.dragunov.watchlyapi.model.WatchStatus;

public record WatchlistItemUpdateRequest(
        WatchStatus status
) {}
