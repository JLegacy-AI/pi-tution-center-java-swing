package application.DataClasses;

import application.GUIComponents.StartGUI.StartGUI;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TuitionCenterTest implements TuitionCenter{

    StartGUI sg = new StartGUI();

    @org.junit.jupiter.api.Test
    void getStudentIDNameTest() {
        for (Student student : students) {
            assertEquals(getStudent(student.getId()).getName(),student.getName());
        }
    }

    @org.junit.jupiter.api.Test
    void getStudentNullTest(){
        assertNull(getStudent("st-121"));
        assertNull(getStudent("st123"));
    }


    @org.junit.jupiter.api.Test
    void getCourseNameTest() {
        for (Course c : courses) {
            assertEquals(getCourse(c.getId()),c.getName());
        }
    }

    @org.junit.jupiter.api.Test
    void courseCapacityCheckTest(){
        assertEquals(getCourse("C-124").getCapacity(),0);
        assertEquals(getCourse("C-123").getCapacity(),3);
    }

    @org.junit.jupiter.api.Test
    void getBookedCourseTest() {
        for (BookedCourses bc : bookedCourses) {
            assertEquals(getBookedCourse(bc.getBookingID()).getCourseID(), bc.getCourseID());
        }
    }

    @org.junit.jupiter.api.Test
    void getBookedCourseNullTest() {
        assertNull(getBookedCourse("invalid"));
    }

    @org.junit.jupiter.api.Test
    void capacityFullTest() {
        for (Course c : courses) {
            assertEquals(capacityFull(c.getId()), c.getCapacity()<1);
        }
    }

    @org.junit.jupiter.api.Test
    void capacityFullNullTest() {
        assertNotEquals(capacityFull("C-123"), true);
    }

    @org.junit.jupiter.api.Test
    void changeCapacity() {
        assertEquals(getCourse("C-123").getCapacity(),3);
        addBookedCourse("C-123","St-129");
        assertEquals(getCourse("C-123").getCapacity(),2);
    }

    @org.junit.jupiter.api.Test
    void changeCapacityFullTest() {
        assertEquals(getCourse("C-123").getCapacity(),3);
        addBookedCourse("C-123","St-129");
        addBookedCourse("C-123","St-139");
        addBookedCourse("C-123","St-138");
        addBookedCourse("C-123","St-137");
        assertEquals(getCourse("C-123").getCapacity(),0);
    }

    @org.junit.jupiter.api.Test
    void addBookedCourse() {
        for (BookedCourses bc : bookedCourses) {
            assertEquals(getBookedCourse(bc.getBookingID()).getStudentID(),bc.getStudentID());
        }
    }

    @org.junit.jupiter.api.Test
    void addBookedCourseSingleCheck() {
        BookedCourses bkc =addBookedCourse("C-124","St-134");
        assertEquals(bkc.getBookingID(), getBookedCourse(bkc.getBookingID()).getBookingID());
    }

    @org.junit.jupiter.api.Test
    void alreadyBookedCourse() {
        assertTrue(alreadyBookedCourse("C-124", "St-134"));
    }

    @org.junit.jupiter.api.Test
    void alreadyBookedCourseRunForAll() {
        for (BookedCourses bc : bookedCourses) {
            assertTrue(alreadyBookedCourse(bc.getCourseID(), bc.getStudentID()));
        }
    }

    @org.junit.jupiter.api.Test
    void getNoteTestForAll() {
        for (Notes note : notes) {
            assertEquals(note.getNotes(),getNote(note.getBid()));
        }
    }

    @org.junit.jupiter.api.Test
    void getNoteNullTest() {
        assertNull(getNote(null));
    }

    @org.junit.jupiter.api.Test
    void addBook() {
        addBook("B-199","Pakistan Studies");
        assertEquals(getBook("B-199").getName(),"Pakistan Studies");
    }

    @org.junit.jupiter.api.Test
    void addBookAllTest() {
        for (Books book : books) {
            assertEquals(book.getId(),getBook(book.getId()).getId());
        }
    }

    @org.junit.jupiter.api.Test
    void getBook() {
        assertEquals(getBook("B-199").getName(),"Pakistan Studies");
    }

    @org.junit.jupiter.api.Test
    void getBookNullTest() {
        assertNull(getBook(null));
    }

    @org.junit.jupiter.api.Test
    void removeBook() {
        removeBook(getBook("B-199"));
        assertNull(getBook("B-199"));
    }

}