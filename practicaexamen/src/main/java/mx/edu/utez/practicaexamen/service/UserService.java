package mx.edu.utez.practicaexamen.service;

import lombok.Setter;
import mx.edu.utez.practicaexamen.config.ApiResponse;
import mx.edu.utez.practicaexamen.model.User;
import mx.edu.utez.practicaexamen.model.UserRepository;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.Optional;
import java.util.Random;

@Service
@Transactional
public class UserService {
    private final UserRepository repository;
    public UserService(UserRepository repository){
        this.repository = repository;
    }
    @Transactional
    public ResponseEntity<ApiResponse> save (User user){
        Random random = new Random();
        StringBuilder randomUsername = new StringBuilder();
        StringBuilder randomPassword = new StringBuilder(8); // Puedes ajustar la longitud según tus necesidades

        user.setUsername(randomUsername.toString());
        user.setPassword(randomPassword.toString());

        return new ResponseEntity<>(new ApiResponse(), HttpStatus.OK);

    }

    private StringBuilder generateRandomUsername() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomUsername = new StringBuilder();

        SecureRandom secureRandom = new SecureRandom();

        // Generar el nombre de usuario de longitud 8
        int usernameLength = 8;
        for (int i = 0; i < usernameLength; i++) {
            int randomIndex = secureRandom.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            randomUsername.append(randomChar);
        }

        // Verificar del nombre de usuario
        int counter = 1;
        while (repository.existsByUsername(randomUsername.toString())) {
            randomUsername.append(counter);
            counter++;
        }

        return randomUsername;
    }

    // Método para generar una contraseña aleatoria con letras y números
    private StringBuilder generateRandomPassword(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomPassword = new StringBuilder();

        SecureRandom secureRandom = new SecureRandom();

        // Genera la contraseña de la longitud especificada
        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            randomPassword.append(randomChar);
        }

        return randomPassword;
    }

    @Transactional  //encontrar por nombre de Usuario
    public Optional<User> findByUsername(String username){
        return repository.findByUsername(username);
    }

    @Transactional
    public ResponseEntity<ApiResponse>deleteByUsername(String username){
        Optional<User> foundUser = repository.findByUsername(username);
        if(foundUser.isPresent()){
            repository.delete(foundUser.get());
            return new ResponseEntity<>(new ApiResponse(HttpStatus.OK, false, "UserDeleted"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse(HttpStatus.BAD_REQUEST, true, "UserNotFound"), HttpStatus.BAD_REQUEST);
    }

}
