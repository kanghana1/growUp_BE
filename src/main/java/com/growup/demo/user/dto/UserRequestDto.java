package com.growup.demo.user.dto;

import lombok.Builder;
import lombok.Data;

public class UserRequestDto {

    @Builder
    @Data
    public static class SignupRequestDto {
        private String userUuid;
        private String name;
        private String password;
        private String email;
    }
}
