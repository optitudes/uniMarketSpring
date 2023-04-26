package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.entidades.Product;
import co.edu.uniquindio.unimarket.entidades.User;

import java.util.List;

public interface UserService {

    User registerUser(User u) throws Exception;

    User updateUser(User u) throws Exception;

    void deleteUser(int id) throws Exception;

    List<User> listUsers();

    List<String[]> listComments();

   List<Product> listFavorites(String email);
}
