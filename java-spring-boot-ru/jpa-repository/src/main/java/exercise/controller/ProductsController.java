package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

import exercise.model.Product;
import exercise.repository.ProductRepository;
import exercise.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    // BEGIN
    @GetMapping(path = "")
    public List<Product> index(@RequestParam(required = false) Integer min, @RequestParam(required = false) Integer max) {
        List<Product> products = null;
        var sort = Sort.by(Sort.Order.asc("price"));
        if (min == null && max == null) {
            return productRepository.findAll(sort);
        }
        if ((min == null) && (!(max == null))) {
            return productRepository.findByPriceLessThanEqualOrderByPrice(max, sort);
        }
        if (!(min == null) && (max == null)) {
            max = Integer.MAX_VALUE;
        }
        if (!(min == null) && (!(max == null))) {
            products = productRepository.findByPriceBetweenOrderByPrice(min, max, sort);
        }
        return products;
    }
    // END

    @GetMapping(path = "/{id}")
    public Product show(@PathVariable long id) {

        var product =  productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));

        return product;
    }
}
