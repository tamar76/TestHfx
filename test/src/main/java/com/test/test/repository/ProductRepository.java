package com.test.test.repository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;
import com.test.test.mock.MockDataGenerator;
import com.test.test.model.Product;

@Repository
public class ProductRepository {
    private final List<Product> products = MockDataGenerator.generateMockProducts();

    public List<Product> getAll() {
        return products;
    }

    public List<Product> getByIds(List<Long> ids) {
        return products.stream().filter(p -> ids.contains(p.getId()))
                .collect(Collectors.toList());
    }

}
