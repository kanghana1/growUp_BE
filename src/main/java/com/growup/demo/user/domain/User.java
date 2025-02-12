package com.growup.demo.user.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;

    @Column(nullable = false, unique = true)
    String userUuid;

    @Column(nullable = false)
    String userName;

    @Column(name = "user_email", unique = true)
    String email;

    @Column(name = "user_password") // 인코딩해야함
    String password;

    LocalDateTime createAt;

    String refreshToken;

    LocalDateTime expiration;

    Boolean isCouple;

}
