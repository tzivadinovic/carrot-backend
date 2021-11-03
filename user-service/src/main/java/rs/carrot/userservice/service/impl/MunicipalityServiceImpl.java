package rs.carrot.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import rs.carrot.userservice.entity.Municipality;
import rs.carrot.userservice.repository.MunicipalityRepository;
import rs.carrot.userservice.service.MunicipalityService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class MunicipalityServiceImpl implements MunicipalityService {
    private final MunicipalityRepository municipalityRepository;

    @Override
    public List<Municipality> findAll(Specification<Municipality> specification, Sort sort) {
        return municipalityRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
    }

    @Override
    public Municipality findById(Integer municipalityId) {
        return municipalityRepository.findById(municipalityId)
                .orElseThrow(() -> new NoSuchElementException("MunicipalityService.notFound"));
    }

    @Override
    public Municipality save(Municipality municipality) {
        return municipalityRepository.save(municipality);
    }

    @Override
    public Municipality update(Municipality municipality) {
        return municipalityRepository.save(municipality);
    }

    @Override
    public void deleteById(Integer municipalityId) {
        municipalityRepository.deleteById(municipalityId);
    }


}