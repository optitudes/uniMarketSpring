package co.edu.uniquindio.unimarket.repo;

import co.edu.uniquindio.unimarket.entidades.ShoppingCart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface ShoppingCartRepo extends JpaRepository<ShoppingCart, Integer> {

    Page<ShoppingCart> findAll(Pageable pageable);

    Optional<ShoppingCart> findById(Integer id);

    @Query("select s.user.name from ShoppingCart s where s.id = :id")
    String obtenerNombreUser(Integer id);


}
