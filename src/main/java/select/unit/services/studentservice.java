package select.unit.services;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import select.unit.Interfaces.Istudent;
import select.unit.exceptions2.badrequestxceptionmessage;
import select.unit.exceptions2.foundokstatus;
import select.unit.exceptions2.messageexception;
import select.unit.repository.Studentrepository;
import select.unit.models.Student;

import javax.ws.rs.BadRequestException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Optional;
@Service
public class studentservice implements Istudent {

    @Autowired
    Studentrepository studentrepo;
    @Override
    public List<Student> getallstudents(){
        return studentrepo.findAll();
    }
    @Override
    public ResponseEntity<Void> addstudent(Student st){
        try {
            studentrepo.save(st);

        }catch (Exception e){
            throw new badrequestxceptionmessage("bad request exception for this student");
        }
        throw new foundokstatus("added"+st.getId());
    }
    @Override
    public ResponseEntity<Void> serchbyid(Student parmstudent, long id){
        Optional<Student> student = studentrepo.findById(id);
        if(student.isPresent()){
            Student st1=student.get();
            st1.setName(parmstudent.getName());
            studentrepo.save(st1);
        }
        else {
            throw new messageexception("runtime exception on updating");
        }
       throw new foundokstatus("founded");
    }
    @Override
    public ResponseEntity<Void> deletbyid(long id){
        Optional<Student> student = studentrepo.findById(id);
        if(student.isPresent())
        {
            studentrepo.deleteById(id);
        }
        else
        {
            throw new messageexception("student with this id"+id+" is not found");
        }
        throw new foundokstatus("founded");
    }

    @Override
    public ResponseEntity<Void> addinfo(Student param, MultipartFile file){
        try {
            param.setImagename(file.getOriginalFilename());
            param.setImagetype(file.getContentType());
            param.setImage(IOUtils.toByteArray(file.getInputStream()));
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("addstudent "+e.getMessage());

        }
        studentrepo.save(param);
        return  ResponseEntity.status(HttpURLConnection.HTTP_CREATED).build();
    }
    @Override
    public ResponseEntity<ByteArrayResource> checkphoto(long id){
        Student student= studentrepo.getById(id);
        try {

            return ResponseEntity.ok().contentType(MediaType.parseMediaType(student.getImagetype()))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + student.getImagename() + "\"")
                    .body(new ByteArrayResource(student.getImage()));
        }
        catch (Exception e){
            throw new messageexception("somthing is wrong for this id "+e.getMessage());

        }

    }

}
