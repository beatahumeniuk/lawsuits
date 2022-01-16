package pl.beatahumeniuk.core.mapper;

import org.mapstruct.Mapper;
import pl.beatahumeniuk.core.model.dto.PlaintiffDTO;
import pl.beatahumeniuk.core.model.entity.Plaintiff;

@Mapper(componentModel = "spring", uses = {RepresentativeMapper.class})
public interface PlaintiffMapper {
    Plaintiff toDO(PlaintiffDTO plaintiffDTO);

    PlaintiffDTO fromDO(Plaintiff plaintiff);
}
