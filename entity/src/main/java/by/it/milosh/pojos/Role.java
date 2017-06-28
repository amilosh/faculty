package by.it.milosh.pojos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
public class Role implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Long role_id;

    @Column(name = "roleName")
    private String roleName;

    @OneToMany(mappedBy = "role")
    private List<User> users = new ArrayList<User>();

    public Role() {
    }

    public Role(String roleName, List<User> users) {
        this.roleName = roleName;
        this.users = users;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_id=" + role_id +
                ", roleName='" + roleName + '\'' +
                '}';
    }

}
