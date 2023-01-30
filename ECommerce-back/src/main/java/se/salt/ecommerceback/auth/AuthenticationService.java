package se.salt.ecommerceback.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import se.salt.ecommerceback.auth.model.AuthenticateRequest;
import se.salt.ecommerceback.auth.model.AuthenticateResponse;
import se.salt.ecommerceback.auth.model.NewUserDto;
import se.salt.ecommerceback.config.JwtService;
import se.salt.ecommerceback.user.model.Role;
import se.salt.ecommerceback.user.model.User;
import se.salt.ecommerceback.user.repository.UserRepository;

@Service
public class AuthenticationService {

    @Autowired
    UserRepository repo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    public AuthenticateResponse register(NewUserDto dto) {
        User user = new User(dto.getUsername(), passwordEncoder.encode(dto.getPassword()), Role.USER);
        repo.save(user);
        var token = jwtService.generateToken(user);
        return new AuthenticateResponse(token);
    }

    public AuthenticateResponse login(AuthenticateRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        User user = repo.getUserByName(request.getUsername());
        var token = jwtService.generateToken(user);
        return new AuthenticateResponse(token);

    }
}
