package select.unit.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import select.unit.exceptions.myIOexception;
import select.unit.exceptions.myexception;
import select.unit.models.Subject;
import select.unit.services.subjectservice;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/subjects")
public class subjectcontroler {
    @Autowired
    subjectservice subjser;


    @GetMapping("/getallsubjects")
    public List<Subject> getallcourse(){
        return subjser.getallsubjects();

    }

    @PostMapping("/postsubject")
    public ResponseEntity<Void> postsubject(@Valid Subject subject,long teacherid){
        return  subjser.addsubjects(subject,teacherid);
    }

    @PutMapping("/{subjectid}/students/{studentid}")
   public ResponseEntity<Void> ennerollstudenttosubject(@PathVariable("subjectid") @Valid long subjectid, @PathVariable("studentid")  @Valid  long studentid)
    {
        return subjser.getbyids(subjectid,studentid);

    }

    @PutMapping("/{subjectid}/teacher/{teacherid}")
    public ResponseEntity<Void> addteachtosubject(@PathVariable("subjectid") @Valid long subjectid, @PathVariable("teacherid")  @Valid  long teacherid)
    {
        return subjser.getbyidS_T(subjectid,teacherid);

    }

    @GetMapping("/getsubjectsbyid/{id}")
    public ResponseEntity<Void> getallcourse(@PathVariable("id") long id) throws myexception {
        return subjser.getsubjbyid(id);
    }
    @DeleteMapping("/deletsubject/{id}")
    public ResponseEntity<Void> deletbyid(@PathVariable("id") long id) throws myIOexception {

        return  subjser.deletbyid(id);
    }

}
