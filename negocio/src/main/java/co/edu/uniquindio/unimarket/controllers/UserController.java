package co.edu.uniquindio.unimarket.controllers;

import co.edu.uniquindio.unimarket.dto.MessageDTO;
import co.edu.uniquindio.unimarket.dto.UserRegisterDTO;
import co.edu.uniquindio.unimarket.entidades.Bill;
import co.edu.uniquindio.unimarket.security.TokenUtils;
import co.edu.uniquindio.unimarket.servicios.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/user")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @PostMapping("/register")
    public ResponseEntity<MessageDTO> register(@Valid @RequestBody UserRegisterDTO userInfo)  throws Exception{
        try{
            Boolean isRegistered = userServiceImpl.registerUser(userInfo);
            if(isRegistered){
                return ResponseEntity.status(200).body( new MessageDTO(HttpStatus.OK, true,"Registro exitoso, revisa el correo que te hemos enviado para verificar la cuenta",null ));
            }else{
                return ResponseEntity.status(200).body( new MessageDTO(HttpStatus.OK, false,"Ocurrió un error al registrar el usuario en la base de datos",null));
            }
        } catch (Exception e) {
            return ResponseEntity.status(200).body( new MessageDTO(HttpStatus.OK, false,"Ocurrió un error",e.getMessage() ));
        }
    }
    @GetMapping("/bill/getAll")
    public ResponseEntity<MessageDTO> getAllBill(HttpServletRequest request)  throws Exception{
        try{
            String authorizationHeader = request.getHeader("Authorization");

            String jwtToken = authorizationHeader.substring(7); // eliminamos el prefijo "Bearer "

            String email = TokenUtils.getEmailFromJWTToken(jwtToken);

            List<Bill> billList = userServiceImpl.getAllBills(email);
            return ResponseEntity.status(200).body( new MessageDTO(HttpStatus.OK, true,"Obtencion de compras correcta",billList ));

        } catch (Exception e) {
            return ResponseEntity.status(200).body( new MessageDTO(HttpStatus.OK, false,"Ocurrió un error",e.getMessage() ));
        }
    }
}
