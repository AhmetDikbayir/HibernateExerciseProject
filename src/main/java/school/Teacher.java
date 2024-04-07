package school;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @Column(name = "teacher_id", unique = true, nullable = false)
    private int id;

    @Column(name = "teacher_name", length = 20)
    private String name;

    @Column(name = "teacher_lastname", length = 20)
    private String lastname;

    @Column(name = "teacher_dept", length = 20)
    private String department;

    public Teacher(int id, String name, String lastname, String department) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Teacher() {
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
