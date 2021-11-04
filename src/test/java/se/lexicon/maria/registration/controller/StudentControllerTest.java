package se.lexicon.maria.registration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import se.lexicon.maria.registration.entity.Student;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private Student student;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        objectMapper = new ObjectMapper();
        student = new Student();
        student.setFirstName("Maria");
        student.setLastName("Svensson");
        student.setAge(53);
        student.setGender("Female");
        student.setEmail("svanteomax@gmail.com");
        student.setPhoneNumber("+46703141108");
        student.setRegisterDate(LocalDate.of(2020, 12, 7));

    }

    @DisplayName("Test 1: Find all students")
    @Test
    public void findAllStudents() throws Exception {
        String jsonMessage = "{\n" +
                "        \"firstName\" : \"Maria\",\n" +
                "        \"lastName\" : \"Svensson\",\n" +
                "        \"age\" : 53,\n" +
                "        \"gender\" : \"Female\",\n" +
                "        \"email\" : \"svanteomax@gmail.com\",\n" +
                "        \"phoneNumber\" : \"+46703141108\",\n" +
                "        \"registerDate\" : \"2020-12-07\",\n" +
                "        \"status\" : \"true\"\n" +
                "    }\n" +
                "    {\n" +
                "        \"firstName\" : \"Anton\",\n" +
                "        \"lastName\" : \"Svensson\",\n" +
                "        \"age\" : 28,\n" +
                "        \"gender\" : \"Male\",\n" +
                "        \"email\" : \"anton@gmail.com\",\n" +
                "        \"phoneNumber\" : \"+46734167901\",\n" +
                "        \"registerDate\" : \"2021-02-08\",\n" +
                "        \"status\" : \"true\"\n" +
                "    }\n" +
                "    {\n" +
                "        \"firstName\" : \"Ingrid\",\n" +
                "        \"lastName\" : \"Svensson\",\n" +
                "        \"age\" : 83,\n" +
                "        \"gender\" : \"Female\",\n" +
                "        \"email\" : \"ingrid@gmail.com\",\n" +
                "        \"phoneNumber\" : \"+4670523043\",\n" +
                "        \"registerDate\" : \"2021-03-08\",\n" +
                "        \"status\" : \"true\"\n" +
                "    }\n" +
                "    {\n" +
                "        \"firstName\" : \"Andreas\",\n" +
                "        \"lastName\" : \"Svensson\",\n" +
                "        \"age\" : 25,\n" +
                "        \"gender\" : \"Male\",\n" +
                "        \"email\" : \"andreas@gmail.com\",\n" +
                "        \"phoneNumber\" : \"+46708205083\",\n" +
                "        \"registerDate\" : \"2021-04-12\",\n" +
                "        \"status\" : \"true\"\n" +
                "    }\n" +
                "    {\n" +
                "        \"firstName\" : \"Adelina\",\n" +
                "        \"lastName\" : \"Holgersson\",\n" +
                "        \"age\" : 31,\n" +
                "        \"gender\" : \"Female\",\n" +
                "        \"email\" : \"adelina@gmail.com\",\n" +
                "        \"phoneNumber\" : \"+4670346709\",\n" +
                "        \"registerDate\" : \"2020-12-16\",\n" +
                "        \"status\" : \"true\"\n" +
                "    }\n" +
                "    {\n" +
                "        \"firstName\" : \"Filip\",\n" +
                "        \"lastName\" : \"Holgersson\",\n" +
                "        \"age\" : 30,\n" +
                "        \"gender\" : \"Male\",\n" +
                "        \"email\" : \"filip@gmail.com\",\n" +
                "        \"phoneNumber\" : \"+4670452179\",\n" +
                "        \"registerDate\" : \"2021-05-10\",\n" +
                "        \"status\" : \"true\"\n" +
                "    }\n" +
                "}";
        MvcResult mvcResult = mockMvc.perform(get("/api/v1/student/")
                .content(jsonMessage)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
        ).andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(200, status);
    }

    @DisplayName("Test 2: Find student by Id")
    @Test
    public void findById() throws Exception {
        String jsonMessage = "{\n" +
                "        \"firstName\" : \"Maria\",\n" +
                "        \"lastName\" : \"Svensson\",\n" +
                "        \"age\" : 53,\n" +
                "        \"gender\" : \"Female\",\n" +
                "        \"email\" : \"svanteomax@gmail.com\",\n" +
                "        \"phoneNumber\" : \"+46703141108\",\n" +
                "        \"registerDate\" : \"2020-12-07\",\n" +
                "        \"status\" : \"true\"\n" +
                "    }\n" +
                "    }";
        MvcResult mvcResult = mockMvc.perform(get("/api/v1/student/")
                .content(jsonMessage)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
        ).andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(200, status);
    }

    @DisplayName("Test 3: Delete student by Id")
    @Test
    public void deleteById() throws Exception {
        String jsonMessage = "{\n" +
                "        \"firstName\" : \"Maria\",\n" +
                "        \"lastName\" : \"Svensson\",\n" +
                "        \"age\" : 53,\n" +
                "        \"gender\" : \"Female\",\n" +
                "        \"email\" : \"svanteomax@gmail.com\",\n" +
                "        \"phoneNumber\" : \"+46703141108\",\n" +
                "        \"registerDate\" : \"2020-12-07\",\n" +
                "        \"status\" : \"true\"\n" +
                "    }\n" +
                "    }";
        MvcResult mvcResult = mockMvc.perform(delete("/api/v1/student/")
                .content(jsonMessage)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
        ).andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(405, status);
    }

    @DisplayName("Test 4: Save Student")
    @Test
    public void save_student_CREATED() throws Exception {
        String jsonMessage = "{\n" +
                "         \"firstName\" : \"Maria\",\n" +
                "         \"lastName\" : \"Svensson\",\n" +
                "         \"age\" : 53,\n" +
                "         \"gender\" : \"Female\",\n" +
                "         \"email\" : \"svanteomax@gmail.com\",\n" +
                "         \"phoneNumber\" : \"+46703141108\",\n" +
                "         \"registerDate\" : \"2020-12-07\",\n" +
                "         \"status\" : \"true\"\n" +
                "    }\n" +
                "}";
        //String studentJsonMessage = objectMapper.writeValueAsString(student);
        System.out.println("jsonMessage = " + jsonMessage);
        MvcResult mvcResult = mockMvc.perform(post("/api/v1/student/")
                .content(jsonMessage)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
        ).andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(201, status);

    }

    @DisplayName("Test 5: Update Student")
    @Test
    public void updateStudent() throws Exception {
        String jsonMessage = "{\n" +
                "         \"firstName\" : \"Maria\",\n" +
                "         \"lastName\" : \"Svensson\",\n" +
                "         \"age\" : 49,\n" +
                "         \"gender\" : \"Female\",\n" +
                "         \"email\" : \"svanteomax@gmail.com\",\n" +
                "         \"phoneNumber\" : \"+46703141108\",\n" +
                "         \"registerDate\" : \"2020-12-07\",\n" +
                "         \"status\" : \"true\"\n" +
                "}";
        MvcResult mvcResult = mockMvc.perform(put("/api/v1/student/")
                .content(jsonMessage)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
        ).andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(200, status);
    }
}