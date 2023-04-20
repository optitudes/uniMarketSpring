package co.edu.uniquindio.unimarket.repo;

import co.edu.uniquindio.unimarket.entidades.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository

public interface UserRepo  extends JpaRepository<User, Integer> {

    Optional<User> comprobarAutenticacion(String email, String password);

    Optional<User> findByEmailAndPassword(String email, String password);

    Optional<User> findByEmail(String email);

    Page<User> findAll(Pageable paginador);

    Optional <User> findByEmailAndIsActive(String email,boolean isActive);
}
