package ua.dragunov.watchlyapi.external.tmdb.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.dragunov.watchlyapi.external.model.ExternalMediaItemSearchResult;
import ua.dragunov.watchlyapi.external.tmdb.dto.MovieDetailsResponse;
import ua.dragunov.watchlyapi.external.tmdb.dto.MovieSearchResult;
import ua.dragunov.watchlyapi.model.MediaItem;

@Mapper(
        componentModel = "spring"
)
public interface TmdbMediaItemMapper {


    @Mapping(target = "externalId", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "poster", source = "poster")
    @Mapping(target = "releaseDate", source = "releaseDate")
    ExternalMediaItemSearchResult toExternalMediaSearchResult(MovieSearchResult movieSearchResult);


}
