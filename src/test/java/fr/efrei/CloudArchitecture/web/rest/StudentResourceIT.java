package fr.efrei.CloudArchitecture.web.rest;

import fr.efrei.CloudArchitecture.domain.Student;
import fr.efrei.CloudArchitecture.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource(locations= "classpath:application-test.properties" )
public class StudentResourceIT {
    @Autowired
    private StudentRepository studentRepository;

    @Test //Create
    @Transactional
    void createStudent() {
        int databaseSizeBeforeCreate = studentRepository.findAll().size();
        assertThat(databaseSizeBeforeCreate).isEqualTo(5); //since we have 5 students at the beginning

        Student student = new Student();
        student.setId(6);
        student.setName("Clara");
        student.setAge(67);
        studentRepository.save(student);

        List<Student> studentList = studentRepository.findAll();
        assertThat(studentList).hasSize(databaseSizeBeforeCreate + 1); //check if we do have a new student added comparing db size bf and after the add
    }

    @Test //Read
    @Transactional
    void getAllStudents() {
        List<Student> students = studentRepository.findAll();
        assertThat(students).isNotEmpty(); //since we have 5 students at the beginning, cannot be empty
    }


    @Test //Update
    @Transactional
    void updateStudent() {
        Integer studId = 5;
        Student existingStudent = studentRepository.findById(studId).orElse(null);
        assertThat(existingStudent).isNotNull();

        String updateName = "Jean";
        existingStudent.setName(updateName);
        int updateAge = 67;
        existingStudent.setAge(updateAge);
        studentRepository.save(existingStudent);

        Student updateStudent = studentRepository.findById(studId).orElse(null);
        assertThat(updateStudent).isNotNull();
        assertThat(updateStudent.getName()).isEqualTo(updateName);
        assertThat(updateStudent.getAge()).isEqualTo(updateAge);
    }
    @Test //Delete
    @Transactional
    void deleteStudent() {
        int databaseSizeBeforeCreate = studentRepository.findAll().size();

        int studId = 1;
        studentRepository.deleteById(studId);
        Student deletedStudent = studentRepository.findById(studId).orElse(null);
        assertThat(deletedStudent).isNull(); //first check if student is well deleted

        List<Student> studentList = studentRepository.findAll(); //here is the new size of the db after the deletion
        assertThat(studentList).hasSize(databaseSizeBeforeCreate - 1); //second check with db size
    }
}

