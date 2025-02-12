package com.growup.demo.user.controller;

import com.growup.demo.user.domain.User;
import com.growup.demo.user.dto.UserRequestDto;
import com.growup.demo.user.dto.UserResponseDto;
import com.growup.demo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.growup.demo.user.dto.UserRequestDto.*;
import static com.growup.demo.user.dto.UserResponseDto.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public User signup(SignupRequestDto requestDto) {
        UserSignupResponseDto user = userService.save(requestDto);
        return null;
    }

}
