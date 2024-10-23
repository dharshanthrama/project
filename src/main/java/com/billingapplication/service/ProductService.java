package com.billingapplication.service;

import com.billingapplication.model.Product;
import com.billingapplication.repo.ProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepository;

    @Autowired
    private UserService userService; // Service to check if email is registered

    // Generate a 6-digit code for product IDs
    private String generate6DigitCode() {
        return String.format("%06d", (int) (Math.random() * 1000000));
    }

    @Transactional
    public Product createProduct(Product pr) {
        // Check if the user's email is registered
        if (!userService.isEmailRegistered(pr.getUserEmail())) {
            throw new RuntimeException("Email not registered: " + pr.getUserEmail());
        }

        // Generate a product ID if not provided
        if (pr.getProductid() == null || pr.getProductid().isEmpty()) {
            pr.generateProductId();
            // Ensure the generated ID is unique
            while (productRepository.existsById(pr.getProductid())) {
                pr.generateProductId();
            }
        }

        return productRepository.save(pr);
    }

    @Transactional
    public List<Product> saveAllProducts(List<Product> products) {
        // Validate all emails before saving products
        for (Product product : products) {
            if (!userService.isEmailRegistered(product.getUserEmail())) {
                throw new IllegalArgumentException("User with email " + product.getUserEmail() + " does not exist.");
            }
            if (product.getProductid() == null || product.getProductid().isEmpty()) {
                product.generateProductId();
                while (productRepository.existsById(product.getProductid())) {
                    product.generateProductId();
                }
            }
        }

        return productRepository.saveAll(products);
    }

    // Validate if product exists by product ID
    public void validateProduct(String productId) {
        productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product with ID " + productId + " does not exist."));
    }

    public Product updateProduct(String productId, Product productDetails) {
        // Check if the product exists
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product with ID " + productId + " does not exist."));

        // Check if the user with the given email exists
        if (!userService.isEmailRegistered(productDetails.getUserEmail())) {
            throw new IllegalArgumentException("User with email " + productDetails.getUserEmail() + " does not exist.");
        }

        // Update fields of the existing product
        existingProduct.setName(productDetails.getName());
        existingProduct.setCategory(productDetails.getCategory());
        existingProduct.setPrice(productDetails.getPrice());
        existingProduct.setQuantity(productDetails.getQuantity());
        existingProduct.setImage(productDetails.getImage());
        existingProduct.setDescription(productDetails.getDescription());

        return productRepository.save(existingProduct);
    }

    public void deleteProduct(String productId) {
        if (!productRepository.existsById(productId)) {
            throw new IllegalArgumentException("Product with ID " + productId + " does not exist.");
        }

        productRepository.deleteById(productId);
    }

    // Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get product by ID
    public Product getProductById(String productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product with ID " + productId + " does not exist."));
    }
}
