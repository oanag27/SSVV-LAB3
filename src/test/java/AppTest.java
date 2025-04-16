import domain.Student;
import domain.Tema;
import org.junit.jupiter.api.Test;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import service.Service;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.Validator;
import static org.junit.jupiter.api.Assertions.assertEquals;


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
    @Test
    void addValidAssignmentTest() {
        Validator<Tema> temaValidator = new TemaValidator();
        TemaXMLRepository temaRepository = new TemaXMLRepository(temaValidator, "teme.xml");
        Service service = new Service(null, temaRepository, null);

        String id = "49";
        String description = "new test";
        int deadline = 9;
        int startline = 7;

        int result = service.saveTema(id, description, deadline, startline);
        assertEquals(0, result, "Assignment added successfully");
    }
    @Test
    void addAssignmentWithInvalidStartlineTest() {
        Validator<Tema> temaValidator = new TemaValidator();
        TemaXMLRepository temaRepository = new TemaXMLRepository(temaValidator, "teme.xml");
        Service service = new Service(null, temaRepository, null);

        String id = "11";
        String description = "Invalid test case";
        int deadline = 8;
        int invalidStartline = 10;

        int result = service.saveTema(id, description, deadline, invalidStartline);
        assertEquals(1, result, "Assignment with invalid startline not saved");
    }
    @Test
    void addAssignmentWithEmptyIdTest() {
        Validator<Tema> temaValidator = new TemaValidator();
        TemaXMLRepository temaRepository = new TemaXMLRepository(temaValidator, "teme.xml");
        Service service = new Service(null, temaRepository, null);

        String emptyId = "";
        String description = "Empty ID";
        int deadline = 7;
        int startline = 6;

        int result = service.saveTema(emptyId, description, deadline, startline);
        assertEquals(1, result, "Assignment with empty ID should not be saved");
    }

    @Test
    void addAssignmentWithNullDescriptionTest() {
        Validator<Tema> temaValidator = new TemaValidator();
        TemaXMLRepository temaRepository = new TemaXMLRepository(temaValidator, "teme.xml");
        Service service = new Service(null, temaRepository, null);

        String id = "50";
        String nullDescription = null;
        int deadline = 10;
        int startline = 8;

        int result = service.saveTema(id, nullDescription, deadline, startline);
        assertEquals(1, result, "Assignment with null description should not be saved");
    }

    @Test
    void addAssignmentWithDeadlineBeforeStartlineTest() {
        Validator<Tema> temaValidator = new TemaValidator();
        TemaXMLRepository temaRepository = new TemaXMLRepository(temaValidator, "teme.xml");
        Service service = new Service(null, temaRepository, null);

        String id = "51";
        String description = "Deadline before startLine";
        int deadline = 4;
        int startline = 5;

        int result = service.saveTema(id, description, deadline, startline);
        assertEquals(1, result, "Assignment with deadline before startLine should not be saved");
    }

    @Test
    void addAssignmentWithInvalidDeadlineTest() {
        Validator<Tema> temaValidator = new TemaValidator();
        TemaXMLRepository temaRepository = new TemaXMLRepository(temaValidator, "teme.xml");
        Service service = new Service(null, temaRepository, null);

        String id = "52";
        String description = "Invalid deadline";
        int invalidDeadline = 15; // Assuming week range is 1-14
        int startline = 10;

        int result = service.saveTema(id, description, invalidDeadline, startline);
        assertEquals(1, result, "Assignment with invalid deadline should not be saved");
    }
}
