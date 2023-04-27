package co.edu.uniquindio.unimarket.controllers;

import co.edu.uniquindio.unimarket.dto.LoginRequestDTO;
import co.edu.uniquindio.unimarket.dto.LoginResponseDTO;
import co.edu.uniquindio.unimarket.dto.MessageDTO;
import co.edu.uniquindio.unimarket.servicios.UserServiceImpl;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.GrantedAuthority;


import javax.annotation.security.PermitAll;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("api/auth")
public class AuthController {

    private final UserServiceImpl userServiceImpl;


    @PostMapping("/login")
    public ResponseEntity<MessageDTO> login(@RequestParam("email") String email, @RequestParam("password") String password){


        String token = getJWTToken(email);
        LoginResponseDTO loginResponse = new LoginResponseDTO(token);

        return ResponseEntity.status(200).body( new MessageDTO(HttpStatus.OK, true,"login exitoso",loginResponse ));


    }
    @GetMapping("/pan")
    public ResponseEntity<MessageDTO> pan(){
        return ResponseEntity.status(200).body( new MessageDTO(HttpStatus.OK, true,"login exitoso","pan"));


    }

    private String getJWTToken(String username) {
        String secretKey = "estaEsMiClaveSecretaCon512BitsDeLongitudParaHS512a;lsdkj;alksdj309708d9d9d9n";

        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }

}
