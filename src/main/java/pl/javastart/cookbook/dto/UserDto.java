package pl.javastart.cookbook.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    private String email;
    private boolean isAssignedToNewsletter;

    public UserDto() {
    }

    public UserDto(Long id, String firstName, String lastName, LocalDate dateOfBirth, String email, boolean isAssignedToNewsletter) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.isAssignedToNewsletter = isAssignedToNewsletter;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAssignedToNewsletter() {
        return isAssignedToNewsletter;
    }

    public void setAssignedToNewsletter(boolean assignedToNewsletter) {
        isAssignedToNewsletter = assignedToNewsletter;
    }
}
