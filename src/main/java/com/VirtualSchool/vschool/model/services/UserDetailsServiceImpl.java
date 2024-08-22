package com.VirtualSchool.vschool.model.services;

import com.VirtualSchool.vschool.model.User;
import com.VirtualSchool.vschool.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@ToString
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUsername(username);
        System.out.println("role of a fetched user"+user.getRole());
        //System.out.println(UserDetailsImpl.build(user));
        UserDetailsImpl userDetails= UserDetailsImpl.build(user);
        System.out.println(userDetails);
        return userDetails;
    }
}
