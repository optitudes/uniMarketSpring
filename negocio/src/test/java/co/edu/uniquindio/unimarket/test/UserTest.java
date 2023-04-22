package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.entidades.LevelAccess;
import co.edu.uniquindio.unimarket.entidades.User;
import co.edu.uniquindio.unimarket.repo.LevelAccessRepo;
import co.edu.uniquindio.unimarket.repo.UserRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.jdbc.Sql;


import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserTest {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private LevelAccessRepo levelAccessRepo;


    @Test
    @Sql("classpath:dataset.sql")

    public void register(){

        String email = "pablo@gmail.com";
        String password = "rootie";
        String dni = "119112114";
        String phoneNumber = "323323323";
        String address = "calarca";
        boolean isActive = true;
        String name = "pablo";

        User user = new User(1,email,name,password,dni,phoneNumber,address,isActive,null,null,null,null,null);

        User usuarioGuardado = userRepo.save(user);
        Assertions.assertEquals("pablo", usuarioGuardado.getName());
        System.out.println(usuarioGuardado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void updateTest(){
        Optional<User> user = userRepo.findById(1);
        if(user.isPresent()){
            user.get().setName("dahiana");
            userRepo.save(user.get());
            Optional<User> userUpdated = userRepo.findById(1);
            if(userUpdated.isPresent()){
                Assertions.assertEquals("dahiana", user.get().getName());

            }else{
                Assertions.fail("No se encontró el usuario despues de actualizar");
            }
        }else{
            Assertions.fail("No se encontró el usuario");
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void remove(){

        Optional<User> user = userRepo.findById(1);
        if(user.isPresent()){
            userRepo.delete(user.get());
            Assertions.assertFalse(userRepo.findById(1).isPresent());
        }else{
            Assertions.fail("No se encontró el usuario");
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void findByEmailAndPasswordTest(){
        Optional<User> user = userRepo.findByEmailAndPassword("sharon@test.com","password");
        if(user.isPresent()){
            Assertions.assertEquals("Sharon", user.get().getName());
        }else {
            Assertions.fail("No se encontró el usuario");
        }
    }



    @Test
    @Sql("classpath:dataset.sql")
    public void findByEmailTest(){
        Optional<User> user = userRepo.findByEmail("sharon@test.com");
        if(user.isPresent()){
            Assertions.assertEquals("Sharon", user.get().getName());
        }else {
            Assertions.fail("No se encontró el usuario");
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void filtrarEmailTest(){
        Pageable paginador = PageRequest.of(0,2);

        Page<User> list = userRepo.findAll(paginador);
        Assertions.assertNotNull(list, "La lista de usuarios filtrados por email no puede ser nula");
    }
}