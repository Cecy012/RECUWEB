package mx.edu.utez.practicaexamen.controller;

import jakarta.validation.Valid;
import mx.edu.utez.practicaexamen.config.ApiResponse;
import mx.edu.utez.practicaexamen.controller.dto.UserDto;
import mx.edu.utez.practicaexamen.model.User;
import mx.edu.utez.practicaexamen.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse>register(@Valid @RequestBody UserDto dto){
        return service.save(dto.toEntity());
    }
    @GetMapping("/{username}")
    public Optional<User> getUser(@PathVariable String username){return service.findByUsername(username);}
    @DeleteMapping("/{username}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable String username){return service.deleteByUsername(username);}
}
