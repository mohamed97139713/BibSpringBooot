package at.bib.mapper;

import at.bib.dtos.BuchDTO;
import at.bib.model.Buch;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BuchMapper {
    BuchDTO toDto(Buch buch);

    Buch toEntity(BuchDTO buchDTO);
}
