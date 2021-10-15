package rs.carrot.backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import rs.carrot.backend.entity.ProductImage;
import rs.carrot.backend.repository.ProductImageRepository;
import rs.carrot.backend.service.ProductImageService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductImageServiceImpl implements ProductImageService {
    private final ProductImageRepository productImageRepository;

    @Override
    public List<ProductImage> findAll(Specification<ProductImage> specification, Sort sort) {
        return productImageRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
    }

    @Override
    public ProductImage findById(Integer productImageId) {
        return productImageRepository.findById(productImageId)
                .orElseThrow(() -> new NoSuchElementException("ProductImageService.notFound"));
    }

    @Override
    public ProductImage save(ProductImage productImage) {
        return productImageRepository.save(productImage);
    }

    @Override
    public ProductImage update(ProductImage productImage) {
        return productImageRepository.save(productImage);
    }

    @Override
    public void deleteById(Integer productImageId) {
        productImageRepository.deleteById(productImageId);
    }


}