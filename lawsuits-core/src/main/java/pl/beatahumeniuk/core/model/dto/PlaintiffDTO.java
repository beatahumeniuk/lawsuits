package pl.beatahumeniuk.core.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaintiffDTO {

    private Long id;
    private String name;
    private String surname;
    private RepresentativeDTO representative;
}
