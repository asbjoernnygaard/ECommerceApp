package se.salt.ecommerceback.auth.model;

import lombok.Value;

@Value
public class NewUserDto {
    String username;
    String password;
}
