package pl.beatahumeniuk.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.beatahumeniuk.core.model.entity.Lawsuit;

import java.util.Optional;

@Repository
public interface LawsuitRepository extends JpaRepository<Lawsuit, Long> {
    Optional<Lawsuit> findBySignature(String signature);
}
