package com.appsdeveloperblog.photoappa.api.users.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequestModel {
    @NotNull(message = "First name can not be null")
    @Size(min = 2, message = "First name must not be less than 2 characteres")
    private String firstName;
    @NotNull(message = "Last name can not be null")
    @Size(min = 2, message = "Last name must not be less than 2 characteres")
    private String lastName;
    @NotNull(message = "Password can not be null")
    @Size(min = 8, max = 16, message = "Password must be equal or greather than 8 characteres")
    private String password;
    @NotNull(message = "Email can not be null")
    @Email
    private String email;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
