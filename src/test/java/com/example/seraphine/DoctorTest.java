package com.example.seraphine;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.example.seraphine.model.Doctor;
import com.example.seraphine.service.DoctorService;
import org.springframework.context.annotation.Bean;

@DataJpaTest
public class DoctorTest {

    @Autowired
    private DoctorService doctorService;

    @Test
    public void testSaveDoctor() throws Exception {
        Doctor doctor = new Doctor("Trung", "Nguyen", "male", "trung@gmail.com","quan 9", "khoa san", 10, "pregnant, blah blah");
        this.doctorService.saveDoctor(doctor);
        doctorService.getDoctorById(1L).map(newDoctor -> {
            Assert.assertEquals("Trung", newDoctor.getFirstName());
            return true;
        });


    }
}
