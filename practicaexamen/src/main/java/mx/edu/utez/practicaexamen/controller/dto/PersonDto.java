package mx.edu.utez.practicaexamen.controller.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.practicaexamen.model.Person;

@Getter
@Setter
@NoArgsConstructor

public class PersonDto {
    private Long id;
    private String name;
    private String lastname;
    private String lastnametwo;
    private String address;
    private String contact;

    public Person toEntity() {
        return new Person(name, lastname, lastnametwo, address, contact);
    }
}
