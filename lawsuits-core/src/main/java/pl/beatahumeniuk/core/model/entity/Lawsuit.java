package pl.beatahumeniuk.core.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import pl.beatahumeniuk.core.model.enums.LawsuitCode;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lawsuit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lawsuit_seq")
    @SequenceGenerator(name = "lawsuit_seq", sequenceName = "lawsuit_seq", allocationSize = 1)
    private Long id;
    private String signature;
    private OffsetDateTime date;
    @OneToOne(cascade = CascadeType.ALL)
    private Court court;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "lawsuit_plaintiffs",
            joinColumns = { @JoinColumn(name = "lawsuit_id") },
            inverseJoinColumns = { @JoinColumn(name = "plaintiff_id") }
    )
    private List<Plaintiff> plaintiffs;
    @OneToOne(cascade = CascadeType.ALL)
    private Respondent respondent;
    private String lawsuitResponse;
    @Enumerated(EnumType.STRING)
    private LawsuitCode code;
}
