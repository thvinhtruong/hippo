package com.example.seraphine.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "User")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String dateOfBirth;
    private String insuranceType;
    private String insuranceName;
    private long point_x;
    private long point_y;

    @OneToMany(targetEntity = Appointment.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name ="appointments",referencedColumnName = "id")
    private Set<Appointment> myAppointment = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    private Boolean locked = false;
    private Boolean enabled = false;
    private String resetPasswordToken;

    public User(String firstName, String lastName, String email, String username, String password, String dateOfBirth, String insuranceType, String insuranceName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.insuranceType = insuranceType;
        this.insuranceName = insuranceName;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getFistName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setFistName(String fistName) {
        this.firstName = fistName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Set<Appointment> getMyAppointment() {
        return myAppointment;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getResetPasswordToken(){
        return resetPasswordToken;
    }

    public void setMyAppointment(Set<Appointment> myAppointment) {
        this.myAppointment = myAppointment;
    }

    public void setResetPasswordToken(String resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public long getPoint_x() {
        return point_x;
    }

    public void setPoint_x(long point_x) {
        this.point_x = point_x;
    }

    public long getPoint_y() {
        return point_y;
    }

    public void setPoint_y(long point_y) {
        this.point_y = point_y;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authorities = new SimpleGrantedAuthority(userRole.name());
        return Collections.singletonList(authorities);
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return false;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
