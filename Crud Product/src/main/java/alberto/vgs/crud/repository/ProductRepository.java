package alberto.vgs.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import alberto.vgs.crud.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
