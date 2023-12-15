package fr.efrei.CloudArchitecture.service;

import fr.efrei.CloudArchitecture.domain.Student;
import fr.efrei.CloudArchitecture.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentService {

    public final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student update(Integer id, String name, int age) {
        Student stud = studentRepository.findById(id).orElse(null);
        if (stud != null){
            stud.setName(name);
            stud.setAge(age);
            return studentRepository.save(stud);
        }
        return null;
    }

    public Integer findStudentIdByName(String name) { //check if student exists and returns its id
        Optional<Student> studentOptional = studentRepository.findByName(name);
        return studentOptional.map(Student::getId).orElse(-1);
    }

    public Integer delete(String name){ //delete the student if the id returned exist else id is -1 so it doesn't exist
        Integer id = findStudentIdByName(name);
        if (id != -1) {
            studentRepository.deleteById(id);
        }
        return id;
    }

    public Student create(String name, int age) {
        Student newStudent = new Student();
        newStudent.setName(name);
        newStudent.setAge(age);
        return studentRepository.save(newStudent); // Save the new student to the database
    }
}


