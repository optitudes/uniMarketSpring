package co.edu.uniquindio.unimarket.repo;

import co.edu.uniquindio.unimarket.entidades.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

    Optional<Category> findByName(String name);
    Optional<Category> findByDescription(String description);
    Page<Category> findAll(Pageable pageable);

    Optional<Category> findById(Integer id);

}