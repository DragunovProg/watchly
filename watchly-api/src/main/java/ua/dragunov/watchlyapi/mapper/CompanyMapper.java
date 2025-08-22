package ua.dragunov.watchlyapi.mapper;

import org.mapstruct.Mapper;
import ua.dragunov.watchlyapi.dto.CompanyPreviewResponse;
import ua.dragunov.watchlyapi.model.Company;

@Mapper(componentModel = "spring")
public interface CompanyMapper {


    public CompanyPreviewResponse toPreview(Company company);
}
