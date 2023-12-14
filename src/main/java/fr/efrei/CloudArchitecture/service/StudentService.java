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

    public Student update(Student student){
        return studentRepository.save(student);
    }

    public Integer findStudentIdByName(String name) { //check if student exists and returns its id
        Optional<Student> studentOptional = studentRepository.findByName(name);
        return studentOptional.map(Student::getId).orElse(-1);
    }

    public int delete(String name){ //delete the student if the id returned exist else id is -1 so it doesn't exist
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

        // Save the new student to the database
        return studentRepository.save(newStudent);
    }
}


