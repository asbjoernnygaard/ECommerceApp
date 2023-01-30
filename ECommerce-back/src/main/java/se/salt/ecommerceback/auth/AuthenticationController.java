package se.salt.ecommerceback.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.salt.ecommerceback.auth.model.AuthenticateRequest;
import se.salt.ecommerceback.auth.model.AuthenticateResponse;
import se.salt.ecommerceback.auth.model.NewUserDto;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService service;

    @PostMapping("/signup")
    public ResponseEntity<AuthenticateResponse> signUp(@RequestBody NewUserDto dto) {
        return ResponseEntity.ok(service.register(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticateResponse> login(@RequestBody AuthenticateRequest request) {
        return ResponseEntity.ok(service.login(request));
    }

}
