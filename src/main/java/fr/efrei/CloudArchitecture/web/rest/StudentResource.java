package fr.efrei.CloudArchitecture.web.rest;

import fr.efrei.CloudArchitecture.domain.Student;
import fr.efrei.CloudArchitecture.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentResource {

    public final StudentService studentService;

    public StudentResource (StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/items") //We display all the students
    public List<Student> getAllStudents(){
        return studentService.findAll();
    }

    @DeleteMapping("/items/{studentName}") //We delete the selected name then we display if the action could be done
    public String deleteStudent(@PathVariable String studentName) {
        int result = studentService.delete(studentName);
        return (result == -1) ? studentName + " doesn't exist" : studentName + " was deleted";
    }

    @PostMapping("/items") // Specify the endpoint for creating a student
    public Student createStudent(@RequestBody Student student) {
        return studentService.create(student.getName(), student.getAge());
    }
}