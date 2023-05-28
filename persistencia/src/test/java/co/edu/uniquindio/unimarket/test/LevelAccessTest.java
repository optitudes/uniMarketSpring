package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.entidades.LevelAccess;
import co.edu.uniquindio.unimarket.repo.LevelAccessRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LevelAccessTest {

    @Autowired
    private LevelAccessRepo levelAccessRepo;

    @Test
    public void create(){
        LevelAccess levelAccess = new LevelAccess(1,3,"prueba",null);
        LevelAccess levelAccessSaved = levelAccessRepo.save(levelAccess);
        Assertions.assertEquals("prueba", levelAccessSaved.getDescription());
    }

    @Test
    //@Sql("classpath:dataset.sql")
    public void updateTest(){
        Optional<LevelAccess> levelAccess = levelAccessRepo.findById(1);
        if(levelAccess.isPresent()){
            levelAccess.get().setDescription("Nueva prueba");
            levelAccessRepo.save(levelAccess.get());
            Optional<LevelAccess> levelAccessUpdated = levelAccessRepo.findById(1);
            if(levelAccessUpdated.isPresent()){
                Assertions.assertEquals("Nueva prueba", levelAccessUpdated.get().getDescription());

            }else{
                Assertions.fail("No se encontró el nivel de accesso despues de actualizar");
            }
        }else{
            Assertions.fail("No se encontró el nivel de accesso");
        }
    }


    @Test
    //@Sql("classpath:dataset.sql")
    public void remove(){

        Optional<LevelAccess> levelAccess = levelAccessRepo.findById(1);
        if(levelAccess.isPresent()){
            levelAccessRepo.delete(levelAccess.get());
            Assertions.assertFalse(levelAccessRepo.findById(1).isPresent());
        }else{
            Assertions.fail("No se encontró el nivel de accesso");
        }
    }


}