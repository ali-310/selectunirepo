package select.unit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import select.unit.models.Student;

import java.util.List;
import java.util.Optional;

public interface Studentrepository extends JpaRepository<Student,Long> {
    List<Student> findAll();
    Optional<Student> findById(long id);
    Student  getById(long id);
}
