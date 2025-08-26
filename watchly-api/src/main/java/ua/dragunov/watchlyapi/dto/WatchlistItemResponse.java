package ua.dragunov.watchlyapi.dto;

import ua.dragunov.watchlyapi.model.WatchStatus;

public record WatchlistItemResponse(
        Long id,
        MediaItemPreviewResponse media,
        WatchStatus status
) {}
