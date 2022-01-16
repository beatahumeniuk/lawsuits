package pl.beatahumeniuk.core.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LawsuitCode {
    SENT("123"),
    CREATED("432");
    private final String value;
}
