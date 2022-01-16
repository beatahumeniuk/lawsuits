package pl.beatahumeniuk.core.mapper;

import org.mapstruct.Mapper;
import pl.beatahumeniuk.core.model.dto.CourtDTO;
import pl.beatahumeniuk.core.model.entity.Court;

@Mapper(componentModel = "spring", uses = {AddressMapper.class})
public interface CourtMapper{
    Court toDO(CourtDTO courtDTO);

    CourtDTO fromDO(Court court);
}
