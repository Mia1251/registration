package se.lexicon.maria.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.maria.registration.entity.Student;
import se.lexicon.maria.registration.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<Student>> findAll() {
        List<Student> studentList = new ArrayList<>();
        studentRepository.findAll().iterator().forEachRemaining(studentList::add);
        return ResponseEntity.ok(studentList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable("id") String id) {
        System.out.println("ID" + id);
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") String id) {
        System.out.println("ID" + id);
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            studentRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
    @PostMapping("/")
    public ResponseEntity<Student> save(@RequestBody Student student) {
        System.out.println("student" + student);
        Student result = studentRepository.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/")
    public ResponseEntity<Student> update(@RequestBody Student student) {
        Student result = studentRepository.save(student);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}



