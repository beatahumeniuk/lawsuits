package pl.beatahumeniuk.core.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Respondent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "respondent_seq")
    @SequenceGenerator(name = "respondent_seq", sequenceName = "respondent_seq", allocationSize = 1)
    private Long id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}
