package pl.beatahumeniuk.core.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.beatahumeniuk.core.model.enums.LawsuitCode;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LawsuitDTO {
    private Long id;
    private String signature;
    private OffsetDateTime date;
    private CourtDTO court;
    private List<PlaintiffDTO> plaintiffs;
    private RespondentDTO respondent;
    private String lawsuitResponse;
    private LawsuitCode code;
}
