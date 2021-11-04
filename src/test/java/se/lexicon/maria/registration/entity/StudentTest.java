package se.lexicon.maria.registration.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class StudentTest {

    Student testObject;

    @BeforeEach
    public void setup() {
        testObject = new Student();
        testObject.setFirstName("Maria");
        testObject.setLastName("Svensson");
        testObject.setAge(53);
        testObject.setGender("Female");
        testObject.setEmail("svantematte@hotmail.com");
        testObject.setPhoneNumber("+46703141108");
        testObject.setRegisterDate(LocalDate.of(2020, 12, 07));
        testObject.setStatus(true);
    }

    @DisplayName("Test 1: create student")
    @Test
    public void createStudent() {
        Assertions.assertEquals("Maria", testObject.getFirstName());
        Assertions.assertEquals("Svensson", testObject.getLastName());
        Assertions.assertEquals(53, testObject.getAge());
        Assertions.assertEquals("Female", testObject.getGender());
        Assertions.assertEquals("svantematte@hotmail.com", testObject.getEmail());
        Assertions.assertEquals("+46703141108", testObject.getPhoneNumber());
        Assertions.assertEquals(LocalDate.parse("2020-12-07"), testObject.getRegisterDate());
        Assertions.assertTrue(testObject.isStatus());

        System.out.println("New student created");

    }

    @DisplayName("Test 2: testing Equals")
    @Test
    public void testEquals() {
        Student expected = new Student();
        Assertions.assertEquals("Maria", testObject.getFirstName());
        Assertions.assertEquals("Svensson", testObject.getLastName());
        Assertions.assertEquals(53, testObject.getAge());
        Assertions.assertEquals("Female", testObject.getGender());
        Assertions.assertEquals("svantematte@hotmail.com", testObject.getEmail());
        Assertions.assertEquals("+46703141108", testObject.getPhoneNumber());
        Assertions.assertEquals(LocalDate.parse("2020-12-07"), testObject.getRegisterDate());
        Assertions.assertTrue(testObject.isStatus());

        System.out.println("Equals test passed");
    }

    @DisplayName("Test 3: testing HashCode")
    @Test
    public void testHashCode() {
        Student expedted = new Student();
        Assertions.assertEquals("Maria", testObject.getFirstName());
        Assertions.assertEquals("Svensson", testObject.getLastName());
        Assertions.assertEquals(53, testObject.getAge());
        Assertions.assertEquals("Female", testObject.getGender());
        Assertions.assertEquals("svantematte@hotmail.com", testObject.getEmail());
        Assertions.assertEquals("+46703141108", testObject.getPhoneNumber());
        Assertions.assertEquals(LocalDate.parse("2020-12-07"), testObject.getRegisterDate());
        Assertions.assertTrue(testObject.isStatus());

        System.out.println("HashCode test passed");
    }


}
