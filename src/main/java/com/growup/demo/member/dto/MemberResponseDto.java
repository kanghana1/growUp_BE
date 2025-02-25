package com.growup.demo.member.dto;

import lombok.Builder;
import lombok.Data;

public class MemberResponseDto {

    @Data
    @Builder
    public static class MemberSignupResponseDto {
        private Long idx;
        private String memberName;
        private Boolean isSuccess;
    }

    @Data
    @Builder
    public static class MemberInfoResponseDto {
        private Long idx;
        private String memberId;
        private String memberName;
        private String memberEmail;
        private Boolean isCouple;
    }

    @Data
    @Builder
    public static class MemberUpdateNameResponseDto {
        private Long idx;
        private String memberName;
        private Boolean isSuccess;
    }

    @Data
    @Builder
    public static class MemberUpdateInfoResponseDto {
        private Long idx;
        private String memberName;
        private String memberPassword;
        private String memberEmail;
        private Boolean isSuccess;
    }

    @Builder
    @Data
    public static class MemberDeleteResponseDto {
        private Boolean isSuccess;
    }
}
