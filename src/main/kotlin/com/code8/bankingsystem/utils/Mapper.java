package com.code8.bankingsystem.utils;

import com.code8.bankingsystem.dto.AuthDTO;
import com.code8.bankingsystem.models.User;
import org.springframework.stereotype.Component;


@Component
public class Mapper {
    public User dtoToUser(AuthDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return user;
    }

    public AuthDTO userToDTO(User user){
        return new AuthDTO(user.getEmail(), user.getName());
    }
}
