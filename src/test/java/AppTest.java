import domain.Student;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import repository.StudentFileRepository;
import repository.StudentXMLRepository;
import service.Service;
import validation.StudentValidator;
import validation.Validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}
