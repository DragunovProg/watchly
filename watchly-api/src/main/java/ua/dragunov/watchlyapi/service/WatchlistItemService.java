package ua.dragunov.watchlyapi.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ua.dragunov.watchlyapi.dto.WatchlistItemCreateRequest;
import ua.dragunov.watchlyapi.dto.WatchlistItemResponse;
import ua.dragunov.watchlyapi.dto.WatchlistItemUpdateRequest;
import ua.dragunov.watchlyapi.external.tmdb.TmdbClient;
import ua.dragunov.watchlyapi.mapper.WatchlistItemMapper;
import ua.dragunov.watchlyapi.repository.WatchlistItemRepository;

@Service
public class WatchlistItemService {
    private final WatchlistItemRepository watchlistItemRepository;
    private final WatchlistItemMapper watchlistItemMapper;


    public WatchlistItemService(WatchlistItemRepository watchlistItemRepository, WatchlistItemMapper watchlistItemMapper) {
        this.watchlistItemRepository = watchlistItemRepository;
        this.watchlistItemMapper = watchlistItemMapper;
    }

    public void create(WatchlistItemCreateRequest createRequest) {


    }

    public Page<WatchlistItemResponse> findAll() {

        return null;
    }

    public void updateById(long id, WatchlistItemUpdateRequest watchlistItemUpdateRequest) {

    }

}
