package com.example.jpa.repository;

import com.example.jpa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, String> {

    /**
     **********************************************
     put keyword 'Native' in method name, which gives the ability of executing native query
     **********************************************
     */
    @Modifying
    @Query(value = "delete from user where desc = :desc", nativeQuery = true)
    void deleteNativeByDescription(@Param("desc") String desc);

    void deleteByDescription(String desc);

}
