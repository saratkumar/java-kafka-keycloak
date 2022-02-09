package com.example.samplespringboot.payroll.services;

import com.example.samplespringboot.UsersHelper;
import com.example.samplespringboot.payroll.beans.UserBean;
import com.example.samplespringboot.payroll.beans.UserPojo;
import com.example.samplespringboot.payroll.entities.UserEntity;
import com.example.samplespringboot.payroll.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class    UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UsersHelper loadUserByUsername(final String username) throws UsernameNotFoundException {
        UserPojo usersPojo = null;
        try {
            Optional<UserEntity> userBean = userRepository.findByUsername(username);
            Collection<GrantedAuthority> listOfgrantedAuthorities = new ArrayList<>();
            if(userBean.isPresent()) {
                usersPojo = new UserPojo();
                usersPojo.setUsername(userBean.get().getUsername());
                usersPojo.setPassword(userBean.get().getPassword());
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_SYSTEMADMIN");
                listOfgrantedAuthorities.add(grantedAuthority);
                usersPojo.setListOfgrantedAuthorities(listOfgrantedAuthorities);
                System.out.println(usersPojo.getUsername() + usersPojo.getPassword());
                UsersHelper userDetail = new UsersHelper(usersPojo);
                return userDetail;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
    }

}
