package com.bibvip.crud.repository;


import com.bibvip.crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ef-jorge
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.firstName = ?1")
    List<User> findByFirstName(String firstName);
    @Query("select (count(u) > 0) from User u where u.firstName = ?1")
    Boolean existsUserByFirstName(String firstname);
}
