package com.growup.demo.member.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;

    @Column(nullable = false, unique = true)
    String memberId;

    @Column(nullable = false)
    String memberName;

    @Column(name = "member_email", unique = true)
    String email;

    @Column(name = "member_password") // 인코딩해야함
    String password;

    LocalDateTime createAt;

    String refreshToken;

    LocalDateTime expiration;

    Boolean isCouple;

    public void updateMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void updatePassword(String password) {
        this.password = password;
    }

    public void updateEmail(String email) {
        this.email = email;
    }

}
