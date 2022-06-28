package select.unit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import select.unit.models.Subject;
import select.unit.models.Teachers;

import java.util.List;
import java.util.Optional;

public interface teacherrepository extends JpaRepository<Teachers,Long> {
    List<Teachers> findAll();
    Optional<Teachers> findById(long id);
    Teachers  getById(long id);
}