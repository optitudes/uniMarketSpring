package co.edu.uniquindio.unimarket.repo;

import co.edu.uniquindio.unimarket.entidades.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface ProductRepo extends JpaRepository<Product, Integer> {

    Optional<Product> findByName(String name);
    Optional<Product> findByIsAvailable(Boolean isAvailable);
    List<Product> findByIsActive(Boolean isActive);
    Page<Product> findAll(Pageable pageable);

    Optional<Product> findById(Integer id);

}
