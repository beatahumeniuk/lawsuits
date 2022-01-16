package pl.beatahumeniuk.core.mapper;

import org.mapstruct.Mapper;
import pl.beatahumeniuk.core.model.dto.RespondentDTO;
import pl.beatahumeniuk.core.model.entity.Respondent;

@Mapper(componentModel = "spring")
public interface RespondentMapper {
    Respondent toDO(RespondentDTO representativeDTO);

    RespondentDTO fromDO(Respondent representative);
}
