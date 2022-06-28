package select.unit.models;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id_student", unique = true)
   private long id;
   @NotBlank
   @NotEmpty
   @Column(name = "name")
   private String name;


   @Column(name = "image_name")
   private String imagename;
   @Column(name = "image_type")
   private String imagetype;
   @Lob
   @Column(name = "image")
   private byte[] image;


    @JsonIgnore
    @ManyToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL,  mappedBy = "enrolledstudents")

    private Set<Subject> subjectlist=new HashSet<>();


    @JsonIgnore
    @ManyToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL,  mappedBy = "enrolledstudents")
    private Set<Teachers> teacherslist=new HashSet<>();

    public Student() {

    }

    public Student(String name) {
        this.name = name;
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

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }

    public String getImagetype() {
        return imagetype;
    }

    public void setImagetype(String imagetype) {
        this.imagetype = imagetype;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setSubjectlist(Set<Subject> subjectlist) {
        this.subjectlist=subjectlist;
    }

    public Set<Subject> getSubjectlist() {
        return subjectlist;
    }
    public Set<Teachers> getTeacherslist() {
        return teacherslist;
    }

    public void setTeacherslist(Set<Teachers> teacherslist) {
        this.teacherslist = teacherslist;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imagename='" + imagename + '\'' +
                ", imagetype='" + imagetype + '\'' +
                ", image=" + Arrays.toString(image) +
                ", subjectlist=" + subjectlist +
                ", teacherslist=" + teacherslist +
                '}';
    }
}
