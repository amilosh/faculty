package by.it.milosh.pojos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A class describes the course for teaching.
 * It has properties:
 *     courseName - course name;
 *     userCourse - entity, that defines user's courses, his rating
 *         and teacher, who teach this course.
 */

@Entity
@Table(name = "course")
public class Course implements Serializable {

    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "courseId")
    private Long courseId;

    @Column(name = "courseName", unique = true, nullable = false)
    private String courseName;

    @OneToMany(mappedBy = "course")
    private List<UserCourse> userCourse = new ArrayList<UserCourse>();

    public Course() {
    }

    public Course(String courseName, List<UserCourse> userCourse) {
        this.courseName = courseName;
        this.userCourse = userCourse;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (courseName != null ? !courseName.equals(course.courseName) : course.courseName != null) return false;
        if (courseId != null ? !courseId.equals(course.courseId) : course.courseId != null) return false;
        if (userCourse != null ? !userCourse.equals(course.userCourse) : course.userCourse != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = courseId != null ? courseId.hashCode() : 0;
        result = 31 * result + (courseName != null ? courseName.hashCode() : 0);
        result = 31 * result + (userCourse != null ? userCourse.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                '}';
    }

}
