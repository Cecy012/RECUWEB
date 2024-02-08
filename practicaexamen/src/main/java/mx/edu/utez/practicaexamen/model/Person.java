package mx.edu.utez.practicaexamen.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Length;

@Entity
@Table(name ="people")
@NoArgsConstructor
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 50, nullable = false)
    private String lastname;
    @Column(length = 50, nullable = false)
    private String lastnametwo;
    @Column(length = 50, nullable = false)
    private String address;
    @Column(length = 50, nullable = false)
    private String contact;

    public Person(Long id, String name, String lastname, String lastnametwo, String address, String contact) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.lastnametwo = lastnametwo;
        this.address = address;
        this.contact = contact;
    }
    public Person(String name, String lastname, String lastnametwo, String address, String contact) {
        this.name = name;
        this.lastname = lastname;
        this.lastnametwo = lastnametwo;
        this.address = address;
        this.contact = contact;
    }
}
