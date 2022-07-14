package net.grigdim.sms.repos;

import net.grigdim.sms.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    public Student findByFirstNameIgnoreCase(String firstName);

    public Student findByLastNameIgnoreCase(String lastName);

    public Student findByFirstNameAndLastName(String firstName, String lastName);
}
