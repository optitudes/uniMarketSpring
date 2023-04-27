package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.NegocioApplication;
import co.edu.uniquindio.unimarket.entidades.LevelAccess;
import co.edu.uniquindio.unimarket.entidades.User;
import co.edu.uniquindio.unimarket.servicios.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest(classes= NegocioApplication.class)
@Transactional
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void registerUser(){
        User user = new User(1,"pan@test.com","pan","1234","119119119",323323323,"adders",true,null,null,new LevelAccess(),null,null,null);
        try{
            User userSaved = userService.registerUser(user);
            Assertions.assertNotNull(userSaved);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }
    @Test
    public void removeUser(){
        try{
            userService.deleteUser(2);
            Assertions.assertTrue(true);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

}