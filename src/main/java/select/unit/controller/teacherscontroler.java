package select.unit.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import select.unit.models.Teachers;
import select.unit.services.studentservice;
import select.unit.services.teacherservice;
import javax.validation.Valid;
import java.net.HttpURLConnection;

@RestController
@RequestMapping("/teachers")
public class teacherscontroler {
    @Autowired
    studentservice students;
    @Autowired
    teacherservice ts;

    @GetMapping("/getallteachers")
    public ResponseEntity<Void> getallteachers(){
         ts.getallTeachers();
        return  ResponseEntity.status(HttpURLConnection.HTTP_OK).build();

    }
    @PostMapping("/addstudent")
    public ResponseEntity<Void> addstudent( Teachers t){

        return  ts.addTeachers(t);

    }
    @PutMapping("/updateTeacher/{id}")
    public ResponseEntity<Void> updateTeacher( Teachers t,@PathVariable("id") long id){

        return ts.serchbyid(t,id);
    }
    @DeleteMapping("/deletteacher/{id}")
    public ResponseEntity<Void> deletbyid(@PathVariable("id") @Valid long id){

        return  ts.deletbyid(id);
    }
    //teacher x have student y in rel
    @PutMapping("/{teacherid}/students/{studentid}")
    public ResponseEntity<Void> ennerollstudenttosubject(@PathVariable("teacherid") @Valid long teacherid, @PathVariable("studentid")  @Valid  long studentid)
    {
        return ts.getbyids(teacherid,studentid);

    }

}
