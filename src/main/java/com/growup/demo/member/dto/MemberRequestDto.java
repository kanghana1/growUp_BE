package com.growup.demo.member.dto;

import lombok.Builder;
import lombok.Data;

public class MemberRequestDto {

    @Builder
    @Data
    public static class SignupRequestDto {
        private String memberId;
        private String name;
        private String password;
        private String email;
    }

    @Builder
    @Data
    public static class UpdateNameRequestDto {
        private String memberId;
        private String memberNewName;
    }

    @Builder
    @Data
    public static class UpdateInfoRequestDto {
        private String memberId;
        private String memberNewName;
        private String memberNewPw;
        private String memberNewEmail;
    }
}
