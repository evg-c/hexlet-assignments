package exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

import exercise.model.Product;

import org.springframework.data.domain.Sort;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // BEGIN
    Optional<Product> findByPrice(Integer price);
    List<Product> findAllByPrice(Integer price);
    List<Product> findByPriceLessThan(Integer price);
    List<Product> findByPriceLessThanEqual(Integer price);
    List<Product> findByPriceLessThanEqualOrderByPrice(Integer price, Sort sort);
    List<Product> findByPriceBetween(Integer startPrice, Integer endPrice);
    List<Product> findByPriceBetweenOrderByPrice(Integer startPrice, Integer endPrice, Sort sort);
    // END
}
