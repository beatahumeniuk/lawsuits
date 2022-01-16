package pl.beatahumeniuk.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.beatahumeniuk.core.model.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
