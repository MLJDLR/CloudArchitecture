package fr.efrei.CloudArchitecture.web.rest;

import fr.efrei.CloudArchitecture.domain.Student;
import fr.efrei.CloudArchitecture.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentResource {

    public final StudentService studentService;

    public StudentResource (StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/get") //Read methode - We display all the students
    public List<Student> getAllStudents(){
        return studentService.findAll();
    }

    @DeleteMapping("/delete/{studentName}") //Delete method - We delete the selected name then we display if the action could be done
    public String deleteStudent(@PathVariable String studentName) {
        int result = studentService.delete(studentName);
        return (result == -1) ? studentName + " doesn't exist" : studentName + " was deleted";
    }

    @PostMapping("/create") //Create method - it creates a new student with auto increment ID, need to input name and age
    public Student createStudent(@RequestBody Student student) {
        return studentService.create(student.getName(), student.getAge());
    }

    @PutMapping("/update/{id}") //Update method using the ID to change name and ageof the related student
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
        Student updateStud = studentService.update(id, student.getName(), student.getAge());
        if (updateStud == null) { //if the given ID doesn't exist
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updateStud);
    }
}