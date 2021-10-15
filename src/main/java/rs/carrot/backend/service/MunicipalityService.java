package rs.carrot.backend.service;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import rs.carrot.backend.entity.Municipality;

import java.util.List;

public interface MunicipalityService {

    List<Municipality> findAll(Specification<Municipality> specification, Sort sort);

    Municipality save(Municipality municipality);

    Municipality update(Municipality municipality);

    Municipality findById(Integer municipalityId);

    void deleteById(Integer municipalityId);

}