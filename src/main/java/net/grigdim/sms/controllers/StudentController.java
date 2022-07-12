package net.grigdim.sms.controllers;

import net.grigdim.sms.entities.Student;
import net.grigdim.sms.exceptions.StudentNotFoundException;
import net.grigdim.sms.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public String listStudents(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("students/new")
    public String createStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return  "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable("id") Long id, Model model) throws StudentNotFoundException {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PutMapping("/students/{id}")
    public String updateStudent(@PathVariable("id") Long id, @ModelAttribute("student") Student student, Model model){
        studentService.updateStudent(id, student);
        return "redirect:/students";
    }

//    @GetMapping("/students/{id}")
//    public String deleteStudent(@PathVariable Long id){
//        studentService.deleteStudent(id);
//        return "redirect:/students";
//    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable("id") Long id) throws StudentNotFoundException {
        return studentService.getStudentById(id);
    }
}
