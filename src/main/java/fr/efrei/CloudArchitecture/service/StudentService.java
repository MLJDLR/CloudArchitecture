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

    public Student save(Student student){
        return studentRepository.save(student);
    }//Create

    public Student update(Student student){
        return studentRepository.save(student);
    }

    public Integer findStudentIdByName(String name) {
        Optional<Student> studentOptional = studentRepository.findByName(name);
        return studentOptional.map(Student::getId).orElse(null);
    }

    public void delete(String name){
        Integer id = findStudentIdByName(name);
        studentRepository.deleteById(id);
    }
}


