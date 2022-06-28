package select.unit.Interfaces;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import select.unit.exceptions.myIOexception;
import select.unit.models.Student;
import select.unit.models.Subject;

import java.util.List;

public interface Isubject {
    List<Subject> getallsubjects();
    ResponseEntity<Void> addsubjects(Subject subject,long teacherid);
    ResponseEntity<Void> deletbyid(long id) throws myIOexception;
    ResponseEntity<Void> serchbyid(Student parmstudent, long id);
    ResponseEntity<Void>  getbyids(long subjectid, long studentid);
    ResponseEntity<Void> getbyidS_T(long subjectid, long teacherid);
}
