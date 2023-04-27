package co.edu.uniquindio.unimarket.controllers;

import co.edu.uniquindio.unimarket.dto.MessageDTO;
import co.edu.uniquindio.unimarket.dto.UserRegisterDTO;
import co.edu.uniquindio.unimarket.servicios.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("api/user")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @PostMapping("/register")
    public ResponseEntity<MessageDTO> register(@Valid @RequestBody UserRegisterDTO userInfo)  throws Exception{

            return ResponseEntity.status(200).body( new MessageDTO(HttpStatus.OK, true,"login exitoso",userInfo ));
        }
}
