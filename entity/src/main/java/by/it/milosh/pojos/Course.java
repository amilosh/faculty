package by.it.milosh.pojos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course implements Serializable {

    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_id")
    private Long course_id;

    @Column(name = "courseName")
    private String courseName;

    @OneToMany(mappedBy = "course")
    private List<UserCourse> userCourse = new ArrayList<UserCourse>();

    public Course() {
    }

    public Course(String courseName, List<UserCourse> userCourse) {
        this.courseName = courseName;
        this.userCourse = userCourse;
    }

    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<UserCourse> getUserCourse() {
        return userCourse;
    }

    public void setUserCourse(List<UserCourse> userCourse) {
        this.userCourse = userCourse;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id=" + course_id +
                ", courseName='" + courseName + '\'' +
                '}';
    }

}
