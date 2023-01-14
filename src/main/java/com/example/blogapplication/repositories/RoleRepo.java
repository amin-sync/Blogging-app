package com.example.blogapplication.repositories;

import com.example.blogapplication.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {
}
