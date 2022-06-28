package select.unit.Interfaces;
import org.springframework.core.io.ByteArrayResource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import select.unit.models.Student;
import java.util.List;

public interface Istudent {
    List<Student> getallstudents();
    ResponseEntity<Void> addstudent(Student st);
    ResponseEntity<Void> deletbyid(long id);
     ResponseEntity<Void> serchbyid(Student parmstudent, long id);
    ResponseEntity<Void> addinfo(Student param, MultipartFile file);
    ResponseEntity<ByteArrayResource> checkphoto(long id);






}
