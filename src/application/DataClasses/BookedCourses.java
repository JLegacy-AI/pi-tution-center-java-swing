package application.DataClasses;

public class BookedCourses {

    private String courseStatus;
    private String courseID;
    private String studentID;
    private String bookingID;
    private static int id=1;
    private int review=0;
    public BookedCourses() {
    }

    public BookedCourses( String courseID, String studentID) {
        this.courseStatus = "booked";
        this.courseID = courseID;
        this.studentID = studentID;
        bookingID="B-"+id;
        id++;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(String courseStatus) {
        this.courseStatus = courseStatus;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }
}
