package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public final class StudentTest {
    ///region Test suites for executable domain.Student.equals

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method equals(java.lang.Object)

    /**
     * @utbot.classUnderTest {@link Student}
     * @utbot.methodUnderTest {@link Student#equals(Object)}
     * @utbot.executesCondition {@code (o): False}
     * @utbot.executesCondition {@code (o == null): False}
     * @utbot.executesCondition {@code (getClass() != o.getClass()): True}
     * @utbot.returnsFrom {@code return false;}
     */
    @Test
    @DisplayName("equals: o == null : True -> return false")
    public void testEquals_GetClassNotEqualsOGetClass() {
        Student student = new Student(null, null, 0);
        int[] o = {};

        boolean actual = student.equals(o);

        assertFalse(actual);
    }

    /**
     * @utbot.classUnderTest {@link Student}
     * @utbot.methodUnderTest {@link Student#equals(Object)}
     * @utbot.executesCondition {@code (o): False}
     * @utbot.executesCondition {@code (o == null): True}
     * @utbot.returnsFrom {@code return false;}
     */
    @Test
    @DisplayName("equals: o == null : False -> return false")
    public void testEquals_OEqualsNull() {
        Student student = new Student(null, null, 0);

        boolean actual = student.equals(null);

        assertFalse(actual);
    }

    /**
     * @utbot.classUnderTest {@link Student}
     * @utbot.methodUnderTest {@link Student#equals(Object)}
     * @utbot.executesCondition {@code (o): True}
     * @utbot.returnsFrom {@code return true;}
     */
    @Test
    @DisplayName("equals: o : True -> return true")
    public void testEquals_O() {
        Student student = new Student(null, null, 0);

        boolean actual = student.equals(student);

        assertTrue(actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable domain.Student.getGrupa

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getGrupa()

    /**
     * @utbot.classUnderTest {@link Student}
     * @utbot.methodUnderTest {@link Student#getGrupa()}
     * @utbot.returnsFrom {@code return grupa;}
     */
    @Test
    @DisplayName("getGrupa: -> return grupa")
    public void testGetGrupa_ReturnGrupa() {
        Student student = new Student(null, null, -255);

        int actual = student.getGrupa();

        assertEquals(-255, actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable domain.Student.getID

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getID()

    /**
     * @utbot.classUnderTest {@link Student}
     * @utbot.methodUnderTest {@link Student#getID()}
     * @utbot.returnsFrom {@code public }
     */
    @Test
    @DisplayName("getID: -> public ")
    public void testGetID_Return() {
        Student student = new Student(null, null, 0);

        String actual = student.getID();

        assertNull(actual);
    }
    ///endregion

    ///region FUZZER: TIMEOUTS for method getID()

    /**
     * @utbot.classUnderTest {@link Student}
     * @utbot.methodUnderTest {@link Student#getID()}
     */
    @Test
    @DisplayName("getID: ")
    @Timeout(value = 1000L, unit = TimeUnit.MILLISECONDS)
    public void testGetID() {
        Student student = new Student("#$\\\"'", "#$\\\"'", -1);
        student.setGrupa(-1610612736);
        student.setNume("#$\\\"'");
        
        /* This execution may take longer than the 1000 ms timeout
         and therefore fail due to exceeding the timeout. */
        assertTimeoutPreemptively(Duration.ofMillis(1000L), () -> student.getID());
    }
    ///endregion

    ///endregion

    ///region Test suites for executable domain.Student.getNume

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getNume()

    /**
     * @utbot.classUnderTest {@link Student}
     * @utbot.methodUnderTest {@link Student#getNume()}
     * @utbot.returnsFrom {@code return nume;}
     */
    @Test
    @DisplayName("getNume: -> return nume")
    public void testGetNume_ReturnNume() {
        Student student = new Student(null, null, 0);

        String actual = student.getNume();

        assertNull(actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable domain.Student.hashCode

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method hashCode()

    /**
     * @utbot.classUnderTest {@link Student}
     * @utbot.methodUnderTest {@link Student#hashCode()}
     * @utbot.invokes {@link java.util.Objects#hash(Object[])}
     * @utbot.returnsFrom {@code return Objects.hash(idStudent);}
     */
    @Test
    @DisplayName("hashCode: ObjectsHash -> return Objects.hash(idStudent)")
    public void testHashCode_ObjectsHash() {
        Student student = new Student(null, null, 0);

        int actual = student.hashCode();

        assertEquals(31, actual);
    }
    ///endregion

    ///region FUZZER: TIMEOUTS for method hashCode()

    /**
     * @utbot.classUnderTest {@link Student}
     * @utbot.methodUnderTest {@link Student#hashCode()}
     */
    @Test
    @DisplayName("hashCode: ")
    @Timeout(value = 1000L, unit = TimeUnit.MILLISECONDS)
    public void testHashCode() {
        Student student = new Student("#$\\\"'", "#$\\\"'", 1);
        student.setGrupa(-1610612736);
        student.setNume("#$\\\"'");
        
        /* This execution may take longer than the 1000 ms timeout
         and therefore fail due to exceeding the timeout. */
        assertTimeoutPreemptively(Duration.ofMillis(1000L), () -> student.hashCode());
    }
    ///endregion

    ///endregion

    ///region Test suites for executable domain.Student.setGrupa

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setGrupa(int)

    /**
     * @utbot.classUnderTest {@link Student}
     * @utbot.methodUnderTest {@link Student#setGrupa(int)}
     */
    @Test
    @DisplayName("setGrupa: ")
    public void testSetGrupa() {
        Student student = new Student(null, null, -255);

        student.setGrupa(-255);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable domain.Student.setID

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setID(java.lang.String)

    /**
     * @utbot.classUnderTest {@link Student}
     * @utbot.methodUnderTest {@link Student#setID(String)}
     * @utbot.returnsFrom {@code public }
     */
    @Test
    @DisplayName("setID: -> public ")
    public void testSetID_Return() {
        Student student = new Student(null, null, 0);

        student.setID(((String) null));
    }
    ///endregion

    ///endregion

    ///region Test suites for executable domain.Student.setNume

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setNume(java.lang.String)

    /**
     * @utbot.classUnderTest {@link Student}
     * @utbot.methodUnderTest {@link Student#setNume(String)}
     */
    @Test
    @DisplayName("setNume: ")
    public void testSetNume() {
        Student student = new Student(null, null, 0);

        student.setNume(null);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable domain.Student.toString

    ///region OTHER: SUCCESSFUL EXECUTIONS for method toString()

    @Test
    public void testToString1() {
        String string = "\u0000\u0000";
        Student student = new Student(string, string, 0);

        String actual = student.toString();

        String expected = "Student{idStudent=\u0000\u0000, nume='\u0000\u0000', grupa=0'}";

        assertEquals(expected, actual);
    }
    ///endregion

    ///endregion
}
