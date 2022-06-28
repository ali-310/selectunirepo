package select.unit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import select.unit.models.Student;
import select.unit.models.Subject;

import java.util.List;
import java.util.Optional;
public interface subjectrepository extends JpaRepository<Subject,Long> {
    List<Subject> findAll();
    Optional<Subject> findById(long id);
    Subject  getById(long id);
}