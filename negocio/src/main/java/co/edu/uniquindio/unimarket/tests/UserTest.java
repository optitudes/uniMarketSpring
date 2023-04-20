package co.edu.uniquindio.unimarket.tests;

import co.edu.uniquindio.unimarket.entidades.User;
import co.edu.uniquindio.unimarket.repo.UserRepo;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;
import java.util.Optional;

public class UserTest {

    public UserRepo userRepo;


    @Test
    @Sql("classpath:data.sql")
    public void comprobarAutenticacionTest(){
        Optional<User> user = userRepo.comprobarAutenticacion("email","root");
        System.out.println(user);
    }

    @Test
    @Sql("classpath:data.sql")
    public void findByEmailAndPasswordTest(){
        Optional<User> user = userRepo.findByEmailAndPassword("email","root");
        System.out.println(user);
    }

    @Test
    @Sql("classpath:data.sql")
    public void findByEmailTest(){
        Optional<User> user = userRepo.findByEmail("email");
        System.out.println(user);
    }
    @Test
    @Sql("classpath:data.sql")
    public void filtrarEmailTest(){

        Pageable paginador = PageRequest.of(0,2);

        Page<User> list = userRepo.findAll(paginador);
        System.out.println(list);
    }
}
