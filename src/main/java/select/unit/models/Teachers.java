package select.unit.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teachers")
public class Teachers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id",unique = true)
    private long id;

    @NotBlank
    @NotEmpty
    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "teacherone",cascade = CascadeType.ALL)
  private Set<Subject> subjectlist=new HashSet<>();




    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="teachers_student",joinColumns = @JoinColumn(name = "teacher_id"),inverseJoinColumns = @JoinColumn(name="id_student"))
    private Set<Student> enrolledstudents=new HashSet<>();





    public Teachers(String name) {
        this.name = name;
    }

    public Teachers() {

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

    public Set<Subject> getSubjectlist() {
        return subjectlist;
    }

    public void setSubjectlist(Set<Subject> subjectlist) {
        this.subjectlist = subjectlist;
    }
    public Set<Student> getEnrolledstudents() {
        return enrolledstudents;
    }

    public void assignteachertostudents(Student student) {
        this.enrolledstudents.add(student);
    }
    @Override
    public String toString() {
        return "Teachers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subjectlist=" + subjectlist +
                ", enrolledstudents=" + enrolledstudents +
                '}';
    }


}


