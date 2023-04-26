package co.edu.uniquindio.unimarket.repo;

import co.edu.uniquindio.unimarket.entidades.LevelAccess;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface LevelAccessRepo extends JpaRepository<LevelAccess, Integer> {

    Optional<LevelAccess> findByAccessCode(Integer accessCode);
    Page<LevelAccess> findAll(Pageable pageable);

    Optional<LevelAccess> findById(Integer id);

}