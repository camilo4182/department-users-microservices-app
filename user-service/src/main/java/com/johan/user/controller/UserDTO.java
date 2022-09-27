package com.johan.user.controller;

import com.johan.user.model.User;
import com.johan.user.value_objects.Department;
import lombok.Data;

@Data
public class UserDTO {

    private User user;
    private Department department;

}
