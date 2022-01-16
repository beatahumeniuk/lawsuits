package pl.beatahumeniuk.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.beatahumeniuk.core.model.entity.Plaintiff;

@Repository
public interface PlaintiffRepository extends JpaRepository<Plaintiff, Long> {
}
