package ua.dragunov.watchlyapi.external.tmdb.mapper;

import org.mapstruct.Mapper;
import ua.dragunov.watchlyapi.external.tmdb.dto.TmdbGenreResponse;
import ua.dragunov.watchlyapi.model.Genre;

@Mapper(componentModel = "spring")
public interface TmdbGenreMapper {

    Genre toGenre(TmdbGenreResponse tmdbGenreResponse);
}
