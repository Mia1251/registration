package se.lexicon.maria.registration.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(nullable = false, updatable = false)
    private String id;

    @Column(nullable = false, length = 15)
    private String firstName;

    @Column(nullable = false, length = 30)
    private String lastName;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, length = 15)
    private String phoneNumber;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    private LocalDate registerDate;

    @Column(nullable = false, columnDefinition = "tinyint(1) default 1")
    private boolean status;


}
