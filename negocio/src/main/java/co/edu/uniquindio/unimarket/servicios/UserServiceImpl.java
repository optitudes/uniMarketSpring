package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.dto.LoginRequestDTO;
import co.edu.uniquindio.unimarket.dto.UserRegisterDTO;
import co.edu.uniquindio.unimarket.entidades.Bill;
import co.edu.uniquindio.unimarket.entidades.LevelAccess;
import co.edu.uniquindio.unimarket.entidades.Product;
import co.edu.uniquindio.unimarket.entidades.Users;
import co.edu.uniquindio.unimarket.repo.LevelAccessRepo;
import co.edu.uniquindio.unimarket.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepo userRepo;
    private final LevelAccessRepo levelAccessRepo;


    public UserServiceImpl(UserRepo userRepo, LevelAccessRepo levelAccessRepo) {
        this.userRepo = userRepo;
        this.levelAccessRepo = levelAccessRepo;
    }

    @Override
    public Boolean registerUser(UserRegisterDTO newUserInfo) throws Exception {

        Optional<Users> searched = userRepo.findByDni(newUserInfo.getDni());
        if (searched.isPresent()){
            throw new Exception("El DNI del usuario ya existe");
        }
        searched = userRepo.findByEmail(newUserInfo.getEmail());
        if (searched.isPresent()){
            throw new Exception("El correo del usuario ya existe");
        }
        Users newUser = new Users();

        newUser.setId(1);
        newUser.setName(newUserInfo.getName());
        newUser.setEmail(newUserInfo.getEmail());
        newUser.setDni(newUserInfo.getDni());
        newUser.setPassword(newUserInfo.getPassword());
        newUser.setPhoneNumber(newUserInfo.getPhoneNumber());
        newUser.setAddress(newUserInfo.getAddress());
        newUser.setIsActive(true);

        Optional<LevelAccess> levelAccess = levelAccessRepo.findByAccessCode(2);
        if (levelAccess.isPresent()){
            newUser.setLevelAccess(levelAccess.get());
            return userRepo.save(newUser) != null;
        }else{
            throw new Exception("Ocurrió un error al asignar el nivel de acceso");
        }
    }

    @Override
    public Users updateUser(Users u) throws Exception {
        return userRepo.save(u);
    }

    @Override
    public void deleteUser(int id) throws Exception {
        userRepo.deleteById(id);
    }

    @Override
    public List<Users> listUsers() {
        return userRepo.findAll();
    }


    @Override
    public List<String[]> listComments(){return userRepo.listarNombresUsuariosYComentarios();}

    @Override
    public List<Product> listFavorites(String email){return userRepo.obtenerProductosFavoritosUser(email);}

    @Override
    public String login(LoginRequestDTO loginInfo) throws Exception {

        Optional<Users> user = userRepo.findByEmailAndPassword(loginInfo.getEmail(),loginInfo.getPassword());
        if(user.isPresent()){
            return user.get().getEmail();
        }else{
            throw  new Exception("Error en la clave o contraseña");
        }
    }

    @Override
    public List<Bill> getAllBills(String email) throws Exception {
        return userRepo.getBills(email);
    }


}
