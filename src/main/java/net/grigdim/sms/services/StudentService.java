package net.grigdim.sms.services;

import net.grigdim.sms.entities.Student;
import net.grigdim.sms.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public Student getStudentById(Long id) {
        return studentRepo.findById(id).get();
    }

    public Student updateStudent(Student student) {
        return studentRepo.save(student);
    }

    public void deleteStudent(Long id){
        studentRepo.deleteById(id);
    }
}
