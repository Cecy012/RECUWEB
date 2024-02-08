package mx.edu.utez.practicaexamen.controller.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.practicaexamen.model.User;

@Setter
@Getter
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private Boolean status;

    public User toEntity(){
        return new User(username, password, status);
    }
}
