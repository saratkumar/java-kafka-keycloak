package com.example.samplespringboot.payroll.repositories;

import com.example.samplespringboot.payroll.beans.UserBean;
import com.example.samplespringboot.payroll.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
    public interface UserRepository extends JpaRepository<UserEntity, Long> {

    public Optional<UserEntity> findByUsername(String username);
}
