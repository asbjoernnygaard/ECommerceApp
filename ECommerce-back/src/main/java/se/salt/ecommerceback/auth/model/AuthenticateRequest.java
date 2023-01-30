package se.salt.ecommerceback.auth.model;

import lombok.Value;

@Value
public class AuthenticateRequest {
    String username;
    String password;
}
