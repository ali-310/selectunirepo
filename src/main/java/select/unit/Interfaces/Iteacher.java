package select.unit.Interfaces;

import org.springframework.http.ResponseEntity;
import select.unit.models.Student;
import select.unit.models.Subject;
import select.unit.models.Teachers;

import java.util.List;

public interface Iteacher {
    List<Teachers> getallTeachers();
    ResponseEntity<Void> addTeachers(Teachers Teacher);
    ResponseEntity<Void> deletbyid(long id);
    ResponseEntity<Void> serchbyid(Teachers parmTeacher, long id);
    ResponseEntity<Void> getbyids(long teacherid, long studentid);

}
