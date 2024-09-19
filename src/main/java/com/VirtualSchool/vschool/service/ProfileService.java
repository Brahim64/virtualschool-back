package com.VirtualSchool.vschool.service;

import com.VirtualSchool.vschool.model.User;
import com.VirtualSchool.vschool.model.dto.UserDTO;
import com.VirtualSchool.vschool.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
 @RequiredArgsConstructor
public class ProfileService {
    private final UserRepository userRepository;

    public UserDTO getProfile(Long id) {
        User user=userRepository.findById(id).get();
        return UserDTO.builder()
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .build();

    }

    public void updateProfile(Long id, UserDTO userDTO) {
        User user=userRepository.findById(id).get();
        user.setUsername(userDTO.getUsername());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPhone(userDTO.getPhone());
        userRepository.save(user);
        System.out.println("done");
    }
}
