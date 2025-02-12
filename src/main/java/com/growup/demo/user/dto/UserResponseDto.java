package com.growup.demo.user.dto;

import lombok.Builder;
import lombok.Data;

public class UserResponseDto {

    @Data
    @Builder
    public static class UserSignupResponseDto {
        private Long idx;
        private String username;
        private boolean isSuccess;
    }
}
