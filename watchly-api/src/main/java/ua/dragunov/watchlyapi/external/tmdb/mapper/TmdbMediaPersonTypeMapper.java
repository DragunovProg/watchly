package ua.dragunov.watchlyapi.external.tmdb.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.dragunov.watchlyapi.external.tmdb.dto.CastResponse;
import ua.dragunov.watchlyapi.external.tmdb.dto.CrewResponse;
import ua.dragunov.watchlyapi.model.Gender;
import ua.dragunov.watchlyapi.model.MediaPersonRole;
import ua.dragunov.watchlyapi.model.Person;
import ua.dragunov.watchlyapi.model.PersonRoleType;

import java.util.Map;

@Mapper(componentModel = "spring")
public interface TmdbMediaPersonTypeMapper {
    static final Map<String, PersonRoleType> tmdbJobMap = Map.ofEntries(
            Map.entry("Acting", PersonRoleType.ACTOR),
            Map.entry("Voice Acting", PersonRoleType.VOICE_ACTOR),
            Map.entry("Directing", PersonRoleType.DIRECTOR),
            Map.entry("Producer", PersonRoleType.PRODUCER),
            Map.entry("Executive Producer", PersonRoleType.EXECUTIVE_PRODUCER),
            Map.entry("Writing", PersonRoleType.WRITER),
            Map.entry("Screenplay", PersonRoleType.SCREENPLAY),
            Map.entry("Original Music Composer", PersonRoleType.COMPOSER),
            Map.entry("Director of Photography", PersonRoleType.CINEMATOGRAPHER),
            Map.entry("Cinematography", PersonRoleType.CINEMATOGRAPHER),
            Map.entry("Editor", PersonRoleType.EDITOR),
            Map.entry("Production Designer", PersonRoleType.PRODUCTION_DESIGNER),
            Map.entry("Art Director", PersonRoleType.ART_DIRECTOR),
            Map.entry("Costume Designer", PersonRoleType.COSTUME_DESIGNER),
            Map.entry("Makeup Artist", PersonRoleType.MAKEUP_ARTIST),
            Map.entry("Visual Effects Supervisor", PersonRoleType.VISUAL_EFFECTS_SUPERVISOR),
            Map.entry("Sound Designer", PersonRoleType.SOUND_DESIGNER),
            Map.entry("Casting Director", PersonRoleType.CASTING_DIRECTOR),
            Map.entry("Stunt Coordinator", PersonRoleType.STUNT_COORDINATOR)
    );

    @Mapping(target = "person.externalId", source = "id")
    @Mapping(target = "person.fullName", source = "fullName")
    @Mapping(target = "person.photoUrl", source = "profilePath")
    @Mapping(target = "person.photoUrl", source = "profilePath")
    @Mapping(target = "person.gender", expression = "java(mapGender(castResponse.gender()))")
    @Mapping(target = "personRoleType", expression = "java(mapCastPersonRoleType())")
    public MediaPersonRole fromCast(CastResponse castResponse);


    @Mapping(target = "person.externalId", source = "id")
    @Mapping(target = "person.fullName", source = "fullName")
    @Mapping(target = "person.photoUrl", source = "profilePath")
    @Mapping(target = "person.photoUrl", source = "profilePath")
    @Mapping(target = "person.gender", expression = "java(mapGender(castResponse.gender()))")
    @Mapping(target = "personRoleType", expression = "java(mapCrewToPersonRoleType(crewResponse.job()))")
    public MediaPersonRole fromCrew(CrewResponse crewResponse);

    default Gender mapGender(int gender) {
        return gender != 0 ? Gender.values()[--gender] : Gender.OTHER;
    }

    default PersonRoleType mapCastPersonRoleType() {
        return PersonRoleType.ACTOR;
    }

    default PersonRoleType mapCrewToPersonRoleType(String job) {
        return tmdbJobMap.getOrDefault(job, PersonRoleType.DIRECTOR);
    }

}
