package org.example;

import org.example.Role;

public class StoreStaff {
    private String firstName;
    private String lastName;
    private static int count = 0;
    private int staffID;

    private Role role;

    public StoreStaff(String firstName, String lastName, Role role) {
        this.staffID = count;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        count++;
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

}

