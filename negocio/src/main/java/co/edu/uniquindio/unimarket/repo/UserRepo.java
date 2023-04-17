package co.edu.uniquindio.unimarket.repo;

import co.edu.uniquindio.unimarket.entidades.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepo  extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.email = :email and u.password = :password")
    User comprobarAutenticacion(String email, String password);

    User findByEmailAndPassword(String email, String password);
}
