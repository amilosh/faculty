package by.it.milosh.pojos;

import javax.persistence.*;

@Entity
@Table(name = "userCourse")
public class UserCourse {

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
    public String toString() {
        return "UserCourse{" +
                "user_course_id=" + user_course_id +
                ", rating=" + rating +
                '}';
    }

}
