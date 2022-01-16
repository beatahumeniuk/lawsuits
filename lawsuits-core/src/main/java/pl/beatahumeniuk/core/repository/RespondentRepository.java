package pl.beatahumeniuk.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.beatahumeniuk.core.model.entity.Respondent;

@Repository
public interface RespondentRepository extends JpaRepository<Respondent, Long> {
}
