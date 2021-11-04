package se.lexicon.maria.registration.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.maria.registration.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, String> {


    List<Student> findByLastNameIgnoreCase(String lastName);

    List<Student> findByFirstNameIgnoreCase(String nameName);

    List<Student> findByFirstNameIgnoreCaseAndLastNameIgnoreCase(String firstName, String lastName);

    Optional<Student> findByEmailIgnoreCase(String email);

}
