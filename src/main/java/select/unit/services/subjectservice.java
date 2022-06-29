package select.unit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import select.unit.Interfaces.Isubject;
import select.unit.exceptions2.messageexception;
import select.unit.models.Student;
import select.unit.models.Subject;
import select.unit.models.Teachers;
import select.unit.repository.Studentrepository;
import select.unit.repository.subjectrepository;
import select.unit.repository.teacherrepository;

import javax.validation.Valid;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Optional;
@Service
public class subjectservice implements Isubject {
    @Autowired
    subjectrepository subrepo;
    @Autowired
    Studentrepository studentrepo;
    @Autowired
    teacherrepository teacherrepo;

    @Override
    public List<Subject> getallsubjects() {
        return subrepo.findAll();
    }

    @Override
    public ResponseEntity<Void> addsubjects(Subject subject,long teacherid) {
       Optional<Teachers>t=teacherrepo.findById(teacherid);
       String name= subject.getName();
       if(t.isPresent()){
         Teachers teacher=t.get();
          Subject sub=new Subject();
          sub.setName(name);
          sub.assigntoteacher(teacher);
           subrepo.save(sub);
       }

        return  ResponseEntity.status(HttpURLConnection.HTTP_CREATED).build();
    }
    @Override
    public ResponseEntity<Void> getbyids(long subjectid, long studentid) {
        Subject subject= subrepo.findById(subjectid).get();
        Student student= studentrepo.findById(studentid).get();

         subject.enerrolStudentlist(student);
         subrepo.save(subject);
        return  ResponseEntity.status(HttpURLConnection.HTTP_CREATED).build();
    }
    @Override
    public ResponseEntity<Void> getbyidS_T(long subjectid, long teacherid) {
      try {
          Subject subject = subrepo.findById(subjectid).get();
          Teachers teacher = teacherrepo.findById(teacherid).get();

          subject.assigntoteacher(teacher);
          subrepo.save(subject);
      }
      catch (Exception e){
          throw new messageexception("somthing is wrong ! maybe teacher with this id or student is not found !  "+e.getMessage());
      }
        return  ResponseEntity.status(HttpURLConnection.HTTP_CREATED).build();
    }

    public ResponseEntity<Void> getsubjbyid( long id) throws messageexception {
        Optional<Subject> subject =subrepo.findById(id);

     if(!subject.isPresent()){
        throw new messageexception("no exsist !");
     }
     else
        return  ResponseEntity.status(HttpURLConnection.HTTP_CREATED).build();

    }


    @Override
    public ResponseEntity<Void> deletbyid(long id) throws messageexception {
        Optional<Subject> subject= subrepo.findById(id);
        if(subject.isPresent()){
            subrepo.deleteById(id);
        }
        else
        {
            throw new messageexception("this is is not found! try again");
        }
        return  ResponseEntity.status(HttpURLConnection.HTTP_OK).build();
    }

    @Override
    public ResponseEntity<Void> serchbyid(Student parmstudent, long id) {
        return null;
    }
}
