package by.it.milosh.pojos;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A class describes the course for teaching.
 * It has properties:
 *     user - student, who enrolled for this course,
 *         or teacher, who teach this course.
 *     course - course;
 *     rating - the student's grade.
 */

@Entity
@Table(name = "userCourse")
public class UserCourse implements Serializable {

    private static final long serialVersionUID = 4L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_course_id")
    private Long user_course_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "rating")
    private Integer rating;

    public UserCourse() {
    }

    public UserCourse(User user, Course course, Integer rating) {
        this.user = user;
        this.course = course;
        this.rating = rating;
    }

    public Long getUser_course_id() {
        return user_course_id;
    }

    public void setUser_course_id(Long user_course_id) {
        this.user_course_id = user_course_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserCourse that = (UserCourse) o;

        if (course != null ? !course.equals(that.course) : that.course != null) return false;
        if (rating != null ? !rating.equals(that.rating) : that.rating != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (user_course_id != null ? !user_course_id.equals(that.user_course_id) : that.user_course_id != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = user_course_id != null ? user_course_id.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (course != null ? course.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserCourse{" +
                "user_course_id=" + user_course_id +
                ", rating=" + rating +
                '}';
    }

}
