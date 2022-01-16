package pl.beatahumeniuk.core.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plaintiff {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "plaintiff_seq")
    @SequenceGenerator(name = "plaintiff_seq", sequenceName = "plaintiff_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String surname;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name="representative_id")
    private Representative representative;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "plaintiffs")
    private List<Lawsuit> lawsuits;
}
