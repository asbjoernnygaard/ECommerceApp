package se.salt.ecommerceback.auth.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class AuthenticateResponse {
    @NonNull
    String token;
}
