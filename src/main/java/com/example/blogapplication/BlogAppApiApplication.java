package com.example.blogapplication;

import com.example.blogapplication.configs.AppConstants;
import com.example.blogapplication.models.Role;
import com.example.blogapplication.repositories.RoleRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class BlogAppApiApplication implements CommandLineRunner {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepo roleRepo;

    public static void main(String[] args) {
        SpringApplication.run(BlogAppApiApplication.class, args);
    }

    @Bean // spring container will create its object and store in container and whenever we need it will provide us
    public ModelMapper modelMapper() {
        return new ModelMapper(); // model mapper is used to map the object to class
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.passwordEncoder.encode("xyz"));
        try {
            Role role = new Role();
            role.setId(AppConstants.ADMIN_USER);
            role.setName("ROLE_ADMIN");

            Role role1 = new Role();
            role1.setId(AppConstants.NORMAL_USER);
            role1.setName("ROLE_NORMAL");

            List<Role> roles = Stream.of(role, role1).collect(Collectors.toList());
            List<Role> result = this.roleRepo.saveAll(roles);
            result.forEach(r -> {
                System.out.println(r.getName());
            });


        } catch (Exception e) {
            e.printStackTrace();

        }
    }


}

