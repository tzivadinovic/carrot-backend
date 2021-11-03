package rs.carrot.productservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import rs.carrot.productservice.entity.ProductOrder;
import rs.carrot.productservice.repository.ProductOrderRepository;
import rs.carrot.productservice.service.ProductOrderService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductOrderServiceImpl implements ProductOrderService {
    private final ProductOrderRepository productOrderRepository;

    @Override
    public List<ProductOrder> findAll(Specification<ProductOrder> specification, Sort sort) {
        return productOrderRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
    }

    @Override
    public ProductOrder findById(Integer productOrderId) {
        return productOrderRepository.findById(productOrderId)
                .orElseThrow(() -> new NoSuchElementException("ProductOrderService.notFound"));
    }

    @Override
    public ProductOrder save(ProductOrder productOrder) {
        return productOrderRepository.save(productOrder);
    }

    @Override
    public ProductOrder update(ProductOrder productOrder) {
        return productOrderRepository.save(productOrder);
    }

    @Override
    public void deleteById(Integer productOrderId) {
        productOrderRepository.deleteById(productOrderId);
    }


}