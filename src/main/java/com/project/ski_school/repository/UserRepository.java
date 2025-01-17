package com.project.ski_school.repository;

import com.project.ski_school.model.Role;
import com.project.ski_school.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<User> findAll();

    Optional<User> findById(Integer id);

    User save(User entity);

    List<User> findUserByRole(Role role);
    boolean existsById(Integer id);
}
