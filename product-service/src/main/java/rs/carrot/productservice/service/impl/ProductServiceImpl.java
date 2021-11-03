package rs.carrot.productservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import rs.carrot.productservice.entity.Product;
import rs.carrot.productservice.repository.ProductRepository;
import rs.carrot.productservice.service.ProductService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll(Specification<Product> specification, Sort sort) {
        return productRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
    }

    @Override
    public Product findById(Integer productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new NoSuchElementException("ProductService.notFound"));
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(Integer productId) {
        productRepository.deleteById(productId);
    }


}