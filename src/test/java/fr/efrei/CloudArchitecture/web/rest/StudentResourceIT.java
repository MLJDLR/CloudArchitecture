package fr.efrei.CloudArchitecture.web.rest;

import fr.efrei.CloudArchitecture.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

//import jakarta.transaction.Transactional;


@SpringBootTest
@TestPropertySource(locations= "classpath:application-test.properties" )
public class StudentResourceIT {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    @Transactional
    void createItem() throws Exception {
        int databaseSizeBeforeCreate = studentRepository.findAll().size();
        assertThat(databaseSizeBeforeCreate).isEqualTo(0);
    }
}

