package pl.beatahumeniuk.core.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "office_seq")
    @SequenceGenerator(name = "office_seq", sequenceName = "office_seq", allocationSize = 1)
    private Long id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}
