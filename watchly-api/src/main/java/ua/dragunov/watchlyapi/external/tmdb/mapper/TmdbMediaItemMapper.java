package ua.dragunov.watchlyapi.external.tmdb.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.dragunov.watchlyapi.external.tmdb.dto.MovieDetailsResponse;
import ua.dragunov.watchlyapi.model.MediaItem;

@Mapper(
        componentModel = "spring"
        , uses = {
            TmdbCompanyMapper.class,
            TmdbGenreMapper.class
        }
)
public interface TmdbMediaItemMapper {

    @Mapping(target = "title", source = "title")
    @Mapping(target = "description", source = "overview")
    @Mapping(target = "poster", source = "poster")
    @Mapping(target = "mediaType", expression = "java()")
    @Mapping(target = "releaseYear", expression = "java()")
    @Mapping(target = "externalId", source = "id")
    @Mapping(target = "genres", source = "genres")
    @Mapping(target = "persons", ignore = true)
    @Mapping(target = "company", expression = "java()")
    MediaItem toMediaItem(MovieDetailsResponse movieDetailsResponse);


}
