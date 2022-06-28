package select.unit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import select.unit.Interfaces.Iteacher;
import select.unit.exceptions.myruntimeexception;
import select.unit.models.Student;
import select.unit.models.Subject;
import select.unit.models.Teachers;
import select.unit.repository.Studentrepository;
import select.unit.repository.teacherrepository;

import javax.ws.rs.BadRequestException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Optional;
@Service
public class teacherservice implements Iteacher {
    @Autowired
    teacherrepository trepo;
    @Autowired
    Studentrepository studentrepo;



    @Override
    public List<Teachers> getallTeachers() {
       return trepo.findAll();
    }

    @Override
    public ResponseEntity<Void> addTeachers(Teachers Teacher) {
        try {
            trepo.save(Teacher);

        }catch (Exception e){
            throw new BadRequestException(e.getMessage());
        }
        return  ResponseEntity.status(HttpURLConnection.HTTP_CREATED).build();
    }

    @Override
    public ResponseEntity<Void> deletbyid(long id) {
        Optional<Teachers> teacher = trepo.findById(id);
        if(teacher.isPresent())
        {
            trepo.deleteById(id);
        }
        else
        {
            throw new RuntimeException("teacher with this id"+id+" is not found");
        }
        return  ResponseEntity.status(HttpURLConnection.HTTP_OK).build();
    }

    @Override
    public ResponseEntity<Void> serchbyid(Teachers parmTeacher, long id) {
        Optional<Teachers> Teacher = trepo.findById(id);
        if(Teacher.isPresent()){
            Teachers t1=Teacher.get();
            t1.setName(parmTeacher.getName());
            trepo.save(t1);
        }
        else {
            throw new myruntimeexception("somthing is wrong ! maybe teacher with this id or student is not found !  ");
        }
        return  ResponseEntity.status(HttpURLConnection.HTTP_OK).build();
    }

    @Override
    public ResponseEntity<Void> getbyids(long teacherid, long studentid) {
try {
    Teachers teacher = trepo.findById(teacherid).get();
    Student student = studentrepo.findById(studentid).get();
    teacher.assignteachertostudents(student);
    trepo.save(teacher);
   }
  catch (Exception e){
    throw new myruntimeexception("somthing is wrong ! maybe teacher with this id or student is not found !  "+e.getMessage());

   }

   return  ResponseEntity.status(HttpURLConnection.HTTP_CREATED).build();
    }



}
