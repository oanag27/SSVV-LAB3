import domain.Student;
import org.junit.jupiter.api.Test;
import repository.StudentXMLRepository;
import service.Service;
import validation.StudentValidator;
import validation.Validator;

import java.io.File;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class AppTest {

    @Test
    void exampleTestCase() {
        System.out.println("Running an example test...");
        assert true;
    }
    @Test
    void addValidStudentTest() {
        Validator<Student> validator = new StudentValidator();
        StudentXMLRepository repository = new StudentXMLRepository(validator, "studenti.xml");
        Service service = new Service(repository, null, null);
        String studentId = "12345";
        String studentName = "Patri";
        int studentGroup = 120;
        int result = service.saveStudent(studentId, studentName, studentGroup);
        assertEquals(0, result, "Student should be saved successfully");
    }
    @Test
    void addInvalidStudentTest() {
        Validator<Student> validator = new StudentValidator();
        StudentXMLRepository repository = new StudentXMLRepository(validator, "studenti.xml");
        Service service = new Service(repository, null, null);
        String studentId = "12345";
        String studentName = "Patri";
        int invalidGroup = 100;
        int result = service.saveStudent(studentId, studentName, invalidGroup);
        assertEquals(1, result, "Student with invalid input should not be saved");
    }
    @Test
    void addStudentWithEmptyNameTest() {
        Validator<Student> validator = new StudentValidator();
        StudentXMLRepository repository = new StudentXMLRepository(validator, "studenti.xml");
        Service service = new Service(repository, null, null);
        String studentId = "20001";
        String emptyName = "";
        int group = 120;
        int result = service.saveStudent(studentId, emptyName, group);
        assertEquals(1, result, "Student with empty name should not be saved");
    }
    @Test
    void addStudentWithNullIdTest() {
        Validator<Student> validator = new StudentValidator();
        StudentXMLRepository repository = new StudentXMLRepository(validator, "studenti.xml");
        Service service = new Service(repository, null, null);
        String nullId = null;
        String name = "Ana";
        int group = 120;
        int result = service.saveStudent(nullId, name, group);
        assertEquals(1, result, "Student with null ID should not be saved");
    }
    @Test
    void addStudentWithNegativeGroupTest() {
        Validator<Student> validator = new StudentValidator();
        StudentXMLRepository repository = new StudentXMLRepository(validator, "studenti.xml");
        Service service = new Service(repository, null, null);
        String studentId = "30001";
        String name = "Ion";
        int negativeGroup = -5;
        int result = service.saveStudent(studentId, name, negativeGroup);
        assertEquals(1, result, "Student with negative group number should not be saved");
    }
}
