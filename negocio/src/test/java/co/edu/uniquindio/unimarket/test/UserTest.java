package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.entidades.User;
import co.edu.uniquindio.unimarket.repo.UserRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserTest {

    @Autowired
    private UserRepo userRepo;

    @Test
    public void register(){

        String email = "pablo@gmail.com";
        String password = "rootie";
        String dni = "119112114";
        String phoneNumber = "323323323";
        String address = "calarca";
        boolean isActive = true;
        String name = "pablo";


        User user = new User(1L,email,name,password,dni,phoneNumber,address,isActive,null,null,null,null,null);

        User usuarioGuardado = userRepo.save(user);
        Assertions.assertEquals("pablo", usuarioGuardado.getName());
        System.out.println(usuarioGuardado);
    }
}