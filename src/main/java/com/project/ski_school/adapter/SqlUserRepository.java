package com.project.ski_school.adapter;


import com.project.ski_school.model.User;
import com.project.ski_school.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface SqlUserRepository extends UserRepository, JpaRepository<User, Integer> {


}
