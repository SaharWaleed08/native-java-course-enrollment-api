package dto.response;

import model.Role;

import java.util.UUID;

public class LoginResponse {

    private UUID id;
    private String fullName;
    private String email;
    private Role role;
    private String message;

}