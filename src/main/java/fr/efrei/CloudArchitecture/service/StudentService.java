package fr.efrei.CloudArchitecture.service;

import fr.efrei.CloudArchitecture.domain.Student;
import fr.efrei.CloudArchitecture.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {

    public final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

}


