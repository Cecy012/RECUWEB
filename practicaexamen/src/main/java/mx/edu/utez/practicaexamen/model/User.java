package mx.edu.utez.practicaexamen.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="users")
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @Column(length = 10, nullable = false)
    private Boolean status;

    public User(Long id, String username, String password, Boolean status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.status = status;
    }
    public User(String username, String password, Boolean status) {
        this.username = username;
        this.password = password;
        this.status = status;
    }
}
