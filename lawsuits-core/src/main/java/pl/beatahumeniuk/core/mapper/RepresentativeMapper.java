package pl.beatahumeniuk.core.mapper;

import org.mapstruct.Mapper;
import pl.beatahumeniuk.core.model.dto.RepresentativeDTO;
import pl.beatahumeniuk.core.model.entity.Representative;

@Mapper(componentModel = "spring", uses = {OfficeMapper.class})
public interface RepresentativeMapper {
    Representative toDO(RepresentativeDTO representativeDTO);

    RepresentativeDTO fromDO(Representative representative);
}
