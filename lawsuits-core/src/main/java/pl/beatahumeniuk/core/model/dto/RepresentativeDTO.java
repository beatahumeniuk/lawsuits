package pl.beatahumeniuk.core.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.beatahumeniuk.core.model.enums.RepresentativeTitle;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepresentativeDTO {

    private Long id;
    private RepresentativeTitle representativeTitle;
    private String name;
    private String surname;
    private OfficeDTO office;
}
