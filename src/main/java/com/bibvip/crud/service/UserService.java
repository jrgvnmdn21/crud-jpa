package com.bibvip.crud.service;

import com.bibvip.crud.exception.ResourceNotFoundException;
import com.bibvip.crud.model.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAllUser();
    Page<User> userPagination(int page, int size);
    Optional<User> findUserById(Long id) throws ResourceNotFoundException;
    User saveUser(User user);
    User updateUser(User user);
    void deleteUserById(Long id);
    List<User> findByFirstName(User user);
}
