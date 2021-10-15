package rs.carrot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import rs.carrot.backend.entity.SubCategory;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer>, JpaSpecificationExecutor<SubCategory> {

}