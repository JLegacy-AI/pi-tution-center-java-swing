package application.DataClasses;

import application.GUIComponents.StudentGUI.StudentGUI;

import java.util.ArrayList;

public interface TuitionCenter {
    ArrayList<Notes> notes = new ArrayList<>();
    ArrayList<Books> books = new ArrayList<>();
    ArrayList<Course> courses = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<BookedCourses> bookedCourses= new ArrayList<>();

    default Student getStudent(String id){
        for (Student student : students) {
            if(student.getId().equalsIgnoreCase(id)){
                return student;
            }
        }
        return null;
    }

    default Course getCourse(String id){
        for (Course course : courses) {
            if(course.getId().equalsIgnoreCase(id)){
                return course;
            }
        }
        return null;
    }

    default BookedCourses getBookedCourse(String bcid){
        for (BookedCourses bc : bookedCourses) {
            if(bc.getBookingID().equalsIgnoreCase(bcid)){
                return bc;
            }
        }
        return null;
    }

    default boolean capacityFull(String cid){
        return getCourse(cid).getCapacity()<1;
    }

    default void changeCapacity(String cid){
        getCourse(cid).setCapacity(getCourse(cid).getCapacity()-1);
    }

    default BookedCourses addBookedCourse(String cid, String sid){
        if(getCourse(cid).getCapacity()>0){
            BookedCourses bc = new BookedCourses(cid, sid);
            bookedCourses.add(bc);
            changeCapacity(cid);
            return bc;
        }
        return null;
    }

    default boolean alreadyBookedCourse(String cid, String sid){
        for (BookedCourses bc : bookedCourses) {
            if(bc.getCourseID().equalsIgnoreCase(cid) && bc.getStudentID().equalsIgnoreCase(sid)){
                return true;
            }
        }
        return false;
    }

    default String getNote(String bid){
        for (Notes note : notes) {
            if(note.getBid().equalsIgnoreCase(bid)){
                return note.getNotes();
            }
        }
        return null;
    }

    default boolean addBook(String id, String name){
        Books bk =new Books(id, name);
        books.add(bk);
        return true;
    }

    default Books getBook(String id){
        for (Books book : books) {
            if(book.getId().equalsIgnoreCase(id)){
                return book;
            }
        }
        return null;
    }

    default void removeBook(Books bk){
        books.remove(bk);
    }

    default int totalNeedBook(){
        int size=0;
        for (Student student : students) {
            size+=student.getNeedBooks().size();
        }
        return size;
    }

    default Student loginStudent(String id, String password){
        for (Student student : students) {
            if(student.getId().equalsIgnoreCase(id) && student.getPassword().equals(password)){
                return student;
            }
        }
        return null;
    }

    default boolean hasBook(Student st, String bid){
        return st.getNeedBooks().contains(getBook(bid));
    }

    default void addStudentBook(Student st, Books bk){
        st.getNeedBooks().add(bk);
    }

    default int studentNeedBookQuantity(String sid){
        int x=0;
        for (BookedCourses b : bookedCourses) {
            if (b.getStudentID().equalsIgnoreCase(sid) && !(b.getReview()>0))
                x++;
        }
        return x;
    }

}
