package mx.edu.utez.practicaexamen.service;

import mx.edu.utez.practicaexamen.config.ApiResponse;
import mx.edu.utez.practicaexamen.model.Person;
import mx.edu.utez.practicaexamen.model.PersonRepository;
import mx.edu.utez.practicaexamen.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PersonService {
    private final PersonRepository repository;
    public PersonService(PersonRepository repository){
        this.repository = repository;
    }
    @Transactional
    public ResponseEntity<ApiResponse> save(Person person){
        return new ResponseEntity<>(new ApiResponse(), HttpStatus.OK);
    }

    @Transactional  //encontrar por id
    public Optional<Person> findById(Long id){
        return repository.findById(id);
    }

    @Transactional
    public ResponseEntity<ApiResponse>deleteById(Long id){
        Optional<Person> foundPerson = repository.findById(id);
        if(foundPerson.isPresent()){
            repository.delete(foundPerson.get());
            return new ResponseEntity<>(new ApiResponse(HttpStatus.OK, false, "UserDeleted"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse(HttpStatus.BAD_REQUEST, true, "UserNotFound"), HttpStatus.BAD_REQUEST);
    }
}
