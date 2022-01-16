package pl.beatahumeniuk.core.mapper;

import org.mapstruct.Mapper;
import pl.beatahumeniuk.core.model.dto.OfficeDTO;
import pl.beatahumeniuk.core.model.entity.Office;

@Mapper(componentModel = "spring", uses = {AddressMapper.class})
public interface OfficeMapper {
    Office toDO(OfficeDTO officeDTO);

    OfficeDTO fromDO(Office office);
}
