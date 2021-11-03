package rs.carrot.productservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import rs.carrot.productservice.entity.ProductBrand;
import rs.carrot.productservice.repository.ProductBrandRepository;
import rs.carrot.productservice.service.ProductBrandService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductBrandServiceImpl implements ProductBrandService {
    private final ProductBrandRepository productBrandRepository;

    @Override
    public List<ProductBrand> findAll(Specification<ProductBrand> specification, Sort sort) {
        return productBrandRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
    }

    @Override
    public ProductBrand findById(Integer productBrandId) {
        return productBrandRepository.findById(productBrandId)
                .orElseThrow(() -> new NoSuchElementException("ProductBrandService.notFound"));
    }

    @Override
    public ProductBrand save(ProductBrand productBrand) {
        return productBrandRepository.save(productBrand);
    }

    @Override
    public ProductBrand update(ProductBrand productBrand) {
        return productBrandRepository.save(productBrand);
    }

    @Override
    public void deleteById(Integer productBrandId) {
        productBrandRepository.deleteById(productBrandId);
    }


}