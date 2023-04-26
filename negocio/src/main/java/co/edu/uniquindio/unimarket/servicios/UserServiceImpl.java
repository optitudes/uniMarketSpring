package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.entidades.Bill;
import co.edu.uniquindio.unimarket.entidades.Product;
import co.edu.uniquindio.unimarket.entidades.User;
import co.edu.uniquindio.unimarket.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User registerUser(User u) throws Exception {
        Optional<User> searched = userRepo.findByDni(u.getDni());
        if (searched.isPresent()){
            throw new Exception("El DNI del usuario ya existe");
        }
        searched = userRepo.findByEmail(u.getEmail());
        if (searched.isPresent()){
            throw new Exception("El correo del usuario ya existe");
        }


        return userRepo.save(u);
    }

    @Override
    public User updateUser(User u) throws Exception {
        return userRepo.save(u);
    }

    @Override
    public void deleteUser(int id) throws Exception {
        userRepo.deleteById(id);
    }

    @Override
    public List<User> listUsers() {
        return userRepo.findAll();
    }

    @Override
    public List<Bill> listBills(Integer userId) {
        return userRepo.getBills(userId);

    }

    @Override
    public List<String[]> listComments(){return userRepo.listarNombresUsuariosYComentarios();}

    @Override
    public List<Product> listFavorites(String email){return userRepo.obtenerProductosFavoritosUser(email);}
}
