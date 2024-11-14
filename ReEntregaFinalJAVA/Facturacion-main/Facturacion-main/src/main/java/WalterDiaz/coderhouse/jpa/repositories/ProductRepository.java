package WalterDiaz.coderhouse.jpa.repositories;

import WalterDiaz.coderhouse.jpa.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByDescription(String description);
}