package ua.dragunov.watchlyapi.service;

import org.springframework.transaction.annotation.Transactional;
import ua.dragunov.watchlyapi.dto.MediaItemResponse;
import ua.dragunov.watchlyapi.mapper.MediaItemMapper;
import ua.dragunov.watchlyapi.model.MediaItem;
import ua.dragunov.watchlyapi.repository.MediaItemRepository;

public class MediaItemService {
    private final MediaItemRepository mediaItemRepository;
    private final MediaItemMapper mediaItemMapper;

    public MediaItemService(MediaItemRepository mediaItemRepository, MediaItemMapper mediaItemMapper) {
        this.mediaItemRepository = mediaItemRepository;
        this.mediaItemMapper = mediaItemMapper;
    }

    @Transactional(readOnly = true)
    public MediaItemResponse findById(Long id) {
        MediaItem mediaItem = mediaItemRepository.findById(id).orElseThrow(() -> new RuntimeException("Media item not found"));

        return mediaItemMapper.toResponse(mediaItem);
    }

    public void create() {}
}
