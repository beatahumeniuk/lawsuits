package pl.beatahumeniuk.core.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RepresentativeTitle {
    LAWYER("adw."),
    SOLICITOR("r.pr.");
    private final String value;
}
