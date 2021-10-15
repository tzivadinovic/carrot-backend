package rs.carrot.backend.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import rs.carrot.backend.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>, JpaSpecificationExecutor<Country> {

}