package com.example.samplespringboot;

//import com.example.samplespringboot.payroll.beans.User;

import com.example.samplespringboot.payroll.beans.UserPojo;
import org.springframework.security.core.userdetails.User;

public class UsersHelper extends User {
    private static final long serialVersionUID = 1L;
    public UsersHelper(UserPojo user) {
        super(
                user.getUsername(),
                user.getPassword(),
                user.getListOfgrantedAuthorities()
        );
    }
}
