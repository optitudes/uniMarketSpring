package co.edu.uniquindio.unimarket.repo;

import co.edu.uniquindio.unimarket.entidades.Product;
import co.edu.uniquindio.unimarket.entidades.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findByEmailAndPassword(String email, String password);

    Optional<User> findByEmail(String email);

    Optional<User> findByDni(String dni);

    Page<User> findAll(Pageable pageable);

    Optional<User> findByEmailAndIsActive(String email, boolean isActive);

    @Query("select p from User u INNER JOIN u.favorite.productList p where u.email = :email")
    List<Product> obtenerProductosFavoritosUser(String email);
    @Query("select p from User u INNER JOIN u.shoppingCart.productList p where u.email = :email")
    List<Product> obtenerProductosCarritoUser(String email);

    @Query("select u.email, c from User u join u.commentList c")
    List<Object[]> listarUsuariosYComentarios();

    @Query("select u.name, c.description from User u join u.couponList c")
    List<String[]> listarUsuariosYCupones();

    @Query("select u.name, c.comment from User u LEFT JOIN u.commentList c")
    List<String[]> listarNombresUsuariosYComentarios();

    @Query("select u from User u where u.name like %:patron%")
    List<User> buscarPatronNombre(String patron);



}