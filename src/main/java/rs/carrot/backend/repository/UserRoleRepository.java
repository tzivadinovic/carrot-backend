package rs.carrot.backend.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import rs.carrot.backend.entity.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer>, JpaSpecificationExecutor<UserRole> {

}