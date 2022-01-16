package pl.beatahumeniuk.core.mapper;

import org.mapstruct.Mapper;
import pl.beatahumeniuk.core.model.dto.LawsuitDTO;
import pl.beatahumeniuk.core.model.entity.Lawsuit;


@Mapper(componentModel = "spring", uses = {CourtMapper.class, PlaintiffMapper.class, RespondentMapper.class})
public interface LawsuitMapper {
    Lawsuit toDO(LawsuitDTO lawsuitDTO);

    LawsuitDTO fromDO(Lawsuit lawsuit);
}
