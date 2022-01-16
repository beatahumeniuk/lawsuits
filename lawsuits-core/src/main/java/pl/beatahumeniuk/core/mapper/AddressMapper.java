package pl.beatahumeniuk.core.mapper;

import org.mapstruct.Mapper;
import pl.beatahumeniuk.core.model.dto.AddressDTO;
import pl.beatahumeniuk.core.model.entity.Address;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address toDO(AddressDTO addressDTO);

    AddressDTO fromDO(Address address);
}
