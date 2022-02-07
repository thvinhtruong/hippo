package com.example.seraphine.model;

import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The class is a model for the Doctor entity.
 * <p>
 * @author Vinh Truong Canh Thanh
 */
@Entity
@Table(name = "Doctor")
@NoArgsConstructor

public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String emails;
    private String address;
    private String specialization;
    private double distance_to_user;
    private String issue_covered;
    @OneToMany(targetEntity = Appointment.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name ="appointments", referencedColumnName = "id")
    List<Appointment> appointments = new ArrayList<>();


    public Doctor(String firstName, String lastName, String gender, String emails, String address, String specialization, double distance_to_user, String issue_covered) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.emails = emails;
        this.address = address;
        this.specialization = specialization;
        this.distance_to_user = distance_to_user;
        this.issue_covered = issue_covered;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public double getDistance_to_user() {
        return distance_to_user;
    }

    public void setDistance_to_user(double distance_to_user) {
        this.distance_to_user = distance_to_user;
    }

    public String getIssue_covered() {
        return issue_covered;
    }

    public void setIssue_covered(String issue_covered) {
        this.issue_covered = issue_covered;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", emails='" + emails + '\'' +
                ", address='" + address + '\'' +
                ", specialization='" + specialization + '\'' +
                ", distance_to_user=" + distance_to_user +
                ", issue_covered='" + issue_covered + '\'' +
                '}';
    }
}
