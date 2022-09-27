package com.johan.user.service;

import com.johan.user.controller.UserDTO;
import com.johan.user.model.User;
import com.johan.user.repository.UserRepository;
import com.johan.user.value_objects.Department;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository repository;
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        return repository.save(user);
    }

    public UserDTO findUserWithDepartment(Long userID) {
        UserDTO userDTO = new UserDTO();
        User user = new User();
        Department department = new Department();
        Optional<User> optionalUser = repository.findById(userID);
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
            department = restTemplate.getForObject("http://department-service/departments/" + user.getDepartmentId(), Department.class);
        }
        userDTO.setUser(user);
        userDTO.setDepartment(department);
        return userDTO;
    }

}
