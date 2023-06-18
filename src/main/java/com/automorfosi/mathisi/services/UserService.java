package com.automorfosi.mathisi.services;

import com.automorfosi.mathisi.models.User;
import com.automorfosi.mathisi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    //adjust the page and size parameters according to your need
    public Page<User> getEnabledUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAllByEnabledTrue(pageable);
    }

}
