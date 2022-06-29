package select.unit.Interfaces;

import org.springframework.http.ResponseEntity;

import select.unit.exceptions2.messageexception;
import select.unit.models.Student;
import select.unit.models.Subject;

import java.util.List;

public interface Isubject {
    List<Subject> getallsubjects();
    ResponseEntity<Void> addsubjects(Subject subject,long teacherid);
    ResponseEntity<Void> deletbyid(long id) throws messageexception;
    ResponseEntity<Void> serchbyid(Student parmstudent, long id);
    ResponseEntity<Void>  getbyids(long subjectid, long studentid);
    ResponseEntity<Void> getbyidS_T(long subjectid, long teacherid);
}
