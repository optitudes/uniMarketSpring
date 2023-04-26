package co.edu.uniquindio.unimarket.repo;

import co.edu.uniquindio.unimarket.entidades.Favorite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface FavoriteRepo extends JpaRepository<Favorite, Integer> {

    Page<Favorite> findAll(Pageable pageable);

    Optional<Favorite> findById(Integer id);

}
