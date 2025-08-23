package ua.dragunov.watchlyapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.dragunov.watchlyapi.dto.MediaItemPreviewResponse;
import ua.dragunov.watchlyapi.dto.MediaItemResponse;
import ua.dragunov.watchlyapi.model.Genre;
import ua.dragunov.watchlyapi.model.MediaItem;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        uses = {PersonMapper.class, CompanyMapper.class})
public interface MediaItemMapper {


    public MediaItemPreviewResponse toPreview(MediaItem mediaItem);

    @Mapping(source = "poster", target = "posterUrl")
    @Mapping(target = "genres", expression = "java(mapGenres(mediaItem.getGenres()))")
    public MediaItemResponse toResponse(MediaItem mediaItem);


    default Set<String> mapGenres(Set<Genre> genres) {
        if (genres == null || genres.isEmpty()) return java.util.Set.of();
        return genres.stream()
                .map(Genre::getName)
                .collect(Collectors.toCollection(java.util.LinkedHashSet::new));
    }
}
