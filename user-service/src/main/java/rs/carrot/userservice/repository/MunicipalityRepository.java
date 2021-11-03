package rs.carrot.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import rs.carrot.userservice.entity.Municipality;

@Repository
public interface MunicipalityRepository extends JpaRepository<Municipality, Integer>, JpaSpecificationExecutor<Municipality> {

}