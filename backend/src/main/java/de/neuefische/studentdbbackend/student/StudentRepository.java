package de.neuefische.studentdbbackend.student;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    Optional<Student> findByMatriculationNumber(String matriculationNumber);

    void deleteByMatriculationNumber(String matriculationNumber);

    List<Student> findAllByFirstNameEqualsIgnoreCase(String firstName);

    List<Student> findAllByLastNameEqualsIgnoreCase(String lastName);

    List<Student> findAllByCourseOfStudiesEqualsIgnoreCase(String course);

    Optional<Student> findByFirstNameAndLastName(String firstName, String lastName);

}
