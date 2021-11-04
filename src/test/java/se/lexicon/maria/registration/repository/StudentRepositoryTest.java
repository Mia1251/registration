package se.lexicon.maria.registration.repository;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import se.lexicon.maria.registration.entity.Student;


public class StudentRepositoryTest {

    @Autowired
    StudentRepository testObject;

    Student student;

    @BeforeEach
    public void setup() {
    }

    @DisplayName("Test 1: Find student by Id")
    @Test
    public void findById() {
    }

    @DisplayName("Test 2: Find all students")
    @Test
    public void findAll() {
    }

    @DisplayName("Test 3: Save student")
    @Test
    public void save() {
    }

    @DisplayName("Test 4: Delete student")
    @Test
    public void delete() {
    }

    @DisplayName("Test 5: Find student by email")
    @Test
    public void findByEmailIgnoreCase() {
    }

    @DisplayName("Test 6: Find student by firstName")
    @Test
    public void findByFirstNameIgnoreCase() {
    }

    @DisplayName("Test 7: Find student by lastName")
    @Test
    public void findByLastNameIgnoreCase() {
    }

    @DisplayName("Test 8: Find student by firstName and lastName")
    @Test
    public void findByFirstNameIgnoreCaseAndLastNameIgnoreCase() {
    }
}


