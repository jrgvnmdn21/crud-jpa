package com.bibvip.crud.service;

import com.bibvip.crud.exception.ResourceNotFoundException;
import com.bibvip.crud.model.User;
import com.bibvip.crud.repository.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> userPagination(int page, int size) {
        Pageable pages = PageRequest.of(page, size);
        return userRepository.findAll(pages);
    }

    @Override
    public Optional<User> findUserById(Long id) throws ResourceNotFoundException {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("Id not found");
        }
        return userRepository.findById(id);
    }
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
//        userRepository.findById(user.getId());
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @SneakyThrows
    public List<User> findByFirstName(User user) {
        if(!userRepository.existsUserByFirstName(user.getFirstName())) {
            throw new ResourceNotFoundException("First name not found");
        }
        return userRepository.findByFirstName(user.getFirstName());
    }


}
