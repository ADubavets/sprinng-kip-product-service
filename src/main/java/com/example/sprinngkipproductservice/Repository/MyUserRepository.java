package com.example.sprinngkipproductservice.Repository;

import com.example.sprinngkipproductservice.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MyUserRepository extends JpaRepository<MyUser, Long> {

    @Query("select u from MyUser u where u.username=:username")
    MyUser getUserByUserName(@Param("username") String username);

    @Query("select u from MyUser u where u.email=:email")
    MyUser getUserByEmail(String email);
}
