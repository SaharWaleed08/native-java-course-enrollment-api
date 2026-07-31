package service;

import dto.request.LoginRequest;
import dto.response.LoginResponse;
import exception.AuthenticationException;
import model.Student;
import repository.InMemoryStudentRepository;
import repository.InMemoryTokenRepository;

import java.util.UUID;

public class AuthenticationService {
    private InMemoryTokenRepository tokenRepository;
    public AuthenticationService(InMemoryTokenRepository tokenRepository){
        this.tokenRepository=new InMemoryTokenRepository();
    }
    public LoginResponse login(LoginRequest request){
        InMemoryStudentRepository studentRepository=new InMemoryStudentRepository();
        Student student = studentRepository.findByEmail(request.getEmail());

        if(student == null){
            throw new AuthenticationException("Invalid credentials");
        }

        if(!student.getPassword().equals(request.getPassword())){
            throw new AuthenticationException("Invalid credentials");
        }

        String token = UUID.randomUUID().toString();

        tokenRepository.save(token, student);

        return new LoginResponse(
                token,
                "Bearer",
                student.getRole()
        );
    }
}
