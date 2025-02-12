package com.growup.demo.user.service;

import com.growup.demo.user.dao.UserRepository;
import com.growup.demo.user.domain.User;
import com.growup.demo.user.dto.UserRequestDto;
import com.growup.demo.user.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.growup.demo.user.dto.UserRequestDto.*;
import static com.growup.demo.user.dto.UserResponseDto.*;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public UserSignupResponseDto save(SignupRequestDto requestDto) {
        if (isExistEmail(requestDto.getEmail())) {
            throw new RuntimeException();
        }
        // uuid 생성해서 넣기

        User user = User.builder()
                .userUuid(null)
                .userName(requestDto.getName())
                .email(requestDto.getEmail())
                .password(requestDto.getPassword())
                .isCouple(false)
                .build();

        repository.save(user);
        return UserSignupResponseDto.builder()
                .idx(user.getIdx())
                .username(user.getUserName())
                .isSuccess(true)
                .build();
    }

    private boolean isExistEmail(String email) {
        return repository.existsByEmail(email);
    }
}
