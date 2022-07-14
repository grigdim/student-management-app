package net.grigdim.sms.services;

import net.grigdim.sms.entities.Student;
import net.grigdim.sms.exceptions.StudentNotFoundException;
import net.grigdim.sms.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    public Student getStudentById(Long id) throws StudentNotFoundException {

        Optional<Student> student = studentRepo.findById(id);

        if (!student.isPresent()) {
            throw new StudentNotFoundException("Student with id : " + id + " was not found");
        }
        return student.get();
    }

    public Student updateStudent(Long id, Student student) {

        Student existingStudent = studentRepo.findById(id).get();

        existingStudent.setId(id);
        if (Objects.nonNull(existingStudent.getFirstName()) && !"".equalsIgnoreCase(existingStudent.getFirstName())) {
            existingStudent.setFirstName(student.getFirstName());
        }
        if (Objects.nonNull(existingStudent.getLastName()) && !"".equalsIgnoreCase(existingStudent.getLastName())) {
            existingStudent.setLastName(student.getLastName());
        }
        if (Objects.nonNull(existingStudent.getEmail()) && !"".equalsIgnoreCase(existingStudent.getEmail())) {
            existingStudent.setEmail(student.getEmail());
        }

        return studentRepo.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }
}
