package select.unit.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subject",unique = true)
    private long id;

    @NotBlank
    @NotEmpty
    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="subject_student",joinColumns = @JoinColumn(name = "id_subject"),inverseJoinColumns = @JoinColumn(name="id_student"))
    private Set<Student> enrolledstudents=new HashSet<>();
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    private Teachers teacherone;

    public Subject(String name) {
        this.name = name;
    }

    public Subject() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getEnrolledstudents() {
        return enrolledstudents;
    }
    public void enerrolStudentlist(Student studentlist) {
        this.enrolledstudents.add(studentlist);
    }

    public Teachers getTeacherone() {
        return teacherone;
    }
    public void assigntoteacher(Teachers teacher) {
        this.teacherone=teacher;
    }
    @Override
    public String toString() {
        return "subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", enrolledstudents=" + enrolledstudents +
                ", teacherone=" + teacherone +
                '}';
    }

}


