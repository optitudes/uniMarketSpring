package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.dto.LoginRequestDTO;
import co.edu.uniquindio.unimarket.dto.UserRegisterDTO;
import co.edu.uniquindio.unimarket.entidades.Bill;
import co.edu.uniquindio.unimarket.entidades.Product;
import co.edu.uniquindio.unimarket.entidades.Users;

import java.util.List;

public interface UserService {

    Boolean registerUser(UserRegisterDTO newUserInfo) throws Exception;

    Users updateUser(Users u) throws Exception;

    void deleteUser(int id) throws Exception;

    List<Users> listUsers();

    List<String[]> listComments();

   List<Product> listFavorites(String email);
   String login(LoginRequestDTO loginInfo) throws Exception;
   List<Bill> getAllBills(String email) throws Exception;
}
