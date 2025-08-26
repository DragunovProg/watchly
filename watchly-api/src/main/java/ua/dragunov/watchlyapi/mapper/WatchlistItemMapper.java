package ua.dragunov.watchlyapi.mapper;

import org.mapstruct.Mapper;
import ua.dragunov.watchlyapi.dto.WatchlistItemResponse;
import ua.dragunov.watchlyapi.dto.WatchlistItemUpdateRequest;
import ua.dragunov.watchlyapi.model.WatchlistItem;

@Mapper(componentModel = "spring"
        , uses = {MediaItemMapper.class})
public interface WatchlistItemMapper {

    public WatchlistItemResponse toResponse(WatchlistItem watchlistItem);

    public WatchlistItem toWatchlistItem(WatchlistItemUpdateRequest watchlistItemUpdateRequest);
}
