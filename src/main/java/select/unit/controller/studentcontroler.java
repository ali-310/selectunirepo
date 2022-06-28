package select.unit.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import select.unit.models.Student;
import select.unit.services.studentservice;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/students")
public class studentcontroler {
    @Autowired
    studentservice students;

    @GetMapping("/getallstudents")
    public List<Student> getallstudents(){
      return students.getallstudents();

    }
    @PostMapping("/addstudent")
    public ResponseEntity<Void> addstudent(@RequestBody Student st){

        return  students.addstudent(st);

    }
    @PutMapping("/updatestudent/{id}")
    public ResponseEntity<Void> updatestudent(@RequestBody @Valid Student student,@PathVariable("id") long id){

        return students.serchbyid(student,id);
    }
    @DeleteMapping("/deletstudent/{id}")
    public ResponseEntity<Void> deletbyid(@PathVariable("id") long id){

        return  students.deletbyid(id);
    }

    @PostMapping("/poststudents")
    public ResponseEntity<Void> poststudents(@Valid Student param, @RequestPart("user_image") MultipartFile file){
        return students.addinfo(param,file);

    }
    @GetMapping("/getstudentimage/{id}")
    public ResponseEntity<ByteArrayResource> getstudentimage(@PathVariable("id")long id){

      return   students.checkphoto(id);
    }


}
