package rs.carrot.backend.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import rs.carrot.backend.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>, JpaSpecificationExecutor<Address> {

}