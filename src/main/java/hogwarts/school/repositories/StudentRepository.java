package hogwarts.school.repositories;

import hogwarts.school.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByAge(int age);
    List<Student> findAllByNameStartsWith(String letter);
    List<Student> findByAgeBetween(int minAge, int maxAge);
    Optional<Student> findById(Long id);


    @Query(value = "SELECT COUNT (*) FROM student", nativeQuery = true)
    Integer getAmountOfStudents();

    @Query(value = "SELECT AVG(age) FROM student", nativeQuery = true)
    Integer averageStudentsAge();

    @Query(value = "SELECT * FROM student ORDER BY id DESC LIMIT 3", nativeQuery = true)
    List<Student> fiveLastStudents();
}
