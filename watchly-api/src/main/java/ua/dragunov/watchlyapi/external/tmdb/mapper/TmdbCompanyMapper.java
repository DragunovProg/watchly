package ua.dragunov.watchlyapi.external.tmdb.mapper;

import org.mapstruct.Mapper;
import ua.dragunov.watchlyapi.external.tmdb.dto.TmdbCompanyResponse;
import ua.dragunov.watchlyapi.model.Company;

@Mapper(componentModel = "spring")
public interface TmdbCompanyMapper {

    Company toCompany(TmdbCompanyResponse tmdbCompanyResponse);
}
