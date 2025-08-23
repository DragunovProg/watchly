package ua.dragunov.watchlyapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.dragunov.watchlyapi.dto.MediaItemPreviewResponse;
import ua.dragunov.watchlyapi.dto.MediaItemResponse;
import ua.dragunov.watchlyapi.dto.MediaItemSearchRequest;
import ua.dragunov.watchlyapi.mapper.MediaItemMapper;
import ua.dragunov.watchlyapi.model.MediaItem;
import ua.dragunov.watchlyapi.repository.MediaItemRepository;
import ua.dragunov.watchlyapi.repository.specification.MediaItemSpecifications;

@Service
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

    @Transactional
    public Page<MediaItemPreviewResponse> search(MediaItemSearchRequest mediaItemSearchRequest) {
        Specification<MediaItem> spec = MediaItemSpecifications.titleContains(mediaItemSearchRequest.searchQuery())
                .and(MediaItemSpecifications.hasType(mediaItemSearchRequest.mediaType()))
                .and(MediaItemSpecifications.releasedIn(mediaItemSearchRequest.releaseYear()))
                .and(MediaItemSpecifications.hasGenres(mediaItemSearchRequest.genres()));

        Pageable pageable = PageRequest.of(mediaItemSearchRequest.page(), mediaItemSearchRequest.size());

        Page<MediaItemPreviewResponse> mediaItems = mediaItemRepository.findAll(spec, pageable).map(mediaItemMapper::toPreview);


        return mediaItems;
    }
}
