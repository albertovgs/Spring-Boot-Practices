package alberto.vgs.crud.services;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alberto.vgs.crud.entity.Product;
import alberto.vgs.crud.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long Id) {
        return productRepository.findById(Id);
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct(Long Id, Product productDetails) {
        Product product = productRepository.findById(Id).orElseThrow(
            () -> new RuntimeException("Product not found")
        );
        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        return productRepository.save(product);
    }

    public void deleteProduct(Long Id) {
        Product product = productRepository.findById(Id).orElseThrow(
            () -> new RuntimeException("Product not found")
        );
        productRepository.delete(product);
    }
    
}
